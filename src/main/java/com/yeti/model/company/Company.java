package com.yeti.model.company;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.action.Action;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.contact.Contact;
import com.yeti.model.general.Attachment;
import com.yeti.model.general.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
@DynamicUpdate
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer companyId;

	@Column(name="company_active")
	private boolean isActive;

	@CreationTimestamp
	@Column(name="company_create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_deactivation_date")
	private Date deactivationDate;

	@Column(name="company_description")
	private String description;

	@Column(name="company_external_id")
	private String externalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_last_modified_date", insertable=false, updatable=false)
	//	@UpdateTimestamp
	private Date lastModifiedDate;

	@Column(name="company_name")
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_target_date")
	private Date targetDate;

	@Column(name="company_valuation")
	private String valuation;

	//bi-directional many-to-one association to CompanyClassificationType
	@ManyToOne
	@JoinColumn(name="company_classification_type_id")
	private CompanyClassificationType classificationType;
	
	//bi-directional many-to-one association to CompanyAddress
	@OneToMany(mappedBy="company", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value="company-address")
	private List<CompanyAddress> addresses;

	//bi-directional many-to-one association to CompanyUrl
	@OneToMany(mappedBy="company", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value="company-url")
	private List<CompanyUrl> urls;
	
	//bi-directional many-to-one association to CompanyAttachment
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
	@JoinTable(name = "company_attachment",
      joinColumns = @JoinColumn(name = "company_id"), 
      inverseJoinColumns = @JoinColumn(name = "attachment_id"))
	//@JsonManagedReference(value="company-attachment")
	private Set<Attachment> attachments;

	//bi-directional many-to-one association to CompanyTag
	@ManyToMany(cascade = { CascadeType.ALL } )
	@JoinTable(name = "company_tag", 
      joinColumns = @JoinColumn(name = "company_id", referencedColumnName="company_id"), 
      inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="tag_id"))
	//@JsonManagedReference(value="company-tag")
	private Set<Tag> tags;


	
	
	
	
	//bi-directional many-to-one association to CompanyUrl
	@OneToMany(mappedBy="company")
	@JsonManagedReference(value="company-contacts")
	// @JsonIgnore
	private List<Contact> contacts;

	
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name = "campaign_company", 
      joinColumns = @JoinColumn(name = "company_id", referencedColumnName="company_id", insertable=true, updatable=true ), 
      inverseJoinColumns = @JoinColumn(name = "campaign_id", referencedColumnName="campaign_id", insertable=true, updatable=true))
	@JsonIgnore
	private List<Campaign> campaigns = new ArrayList<Campaign>(0);
    
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name = "company_action", 
      joinColumns = @JoinColumn(name = "company_id", referencedColumnName="company_id", insertable=true, updatable=true ), 
      inverseJoinColumns = @JoinColumn(name = "action_id", referencedColumnName="action_id", insertable=true, updatable=true))
	@JsonIgnore
	private List<Action> actions = new ArrayList<Action>(0);

    
    
    
    
    
    
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Company() {
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeactivationDate() {
		return this.deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
		
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTargetDate() {
		return this.targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getValuation() {
		return this.valuation;
	}

	public void setValuation(String valuation) {
		this.valuation = valuation;
	}

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public CompanyClassificationType getClassificationType() {
		return this.classificationType;
	}

	public void setClassificationType(CompanyClassificationType classificationType) {
		this.classificationType = classificationType;
	}

	public List<CompanyAddress> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<CompanyAddress> addresses) {
		this.addresses = addresses;
	}

	public Set<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public List<CompanyUrl> getUrls() {
		return this.urls;
	}

	public void setUrls(List<CompanyUrl> urls) {
		this.urls = urls;
	}

}