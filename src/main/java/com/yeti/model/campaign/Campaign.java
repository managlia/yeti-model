package com.yeti.model.campaign;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.action.Action;
import com.yeti.model.company.Company;
import com.yeti.model.contact.Contact;
import com.yeti.model.general.Attachment;
import com.yeti.model.general.ScopeType;
import com.yeti.model.general.Tag;
import com.yeti.model.search.CampaignOrAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the campaign database table.
 * 
 */
@Entity
@NamedQuery(name="Campaign.findAll", query="SELECT c FROM Campaign c")
public class Campaign extends ResourceSupport implements Serializable, Comparable<Campaign> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer campaignId;

	@Column(name="campaign_active")
	private boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_actual_completion_date")
	private Date actualCompletionDate;

	@Column(name="campaign_actual_valuation")
	private String actualValuation;

	@CreationTimestamp
	@Column(name="campaign_create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_deactivation_date")
	private Date deactivationDate;

	@Column(name="campaign_description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_last_modified_date", insertable=false, updatable=false)
	//	@UpdateTimestamp
	private Date lastModifiedDate;

	@Column(name="campaign_name")
	private String name;

	@Column(name="campaign_restrict_to_owner")
	private boolean isRestrictedToOwner;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_target_completion_date")
	private Date targetCompletionDate;

	@Column(name="campaign_target_valuation")
	private String targetValuation;

	//bi-directional many-to-one association to CampaignClassificationType
	@ManyToOne
	@JoinColumn(name="campaign_classification_type_id")
	private CampaignClassificationType classificationType;

	@Column(name="campaign_owner_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer ownerId;

	//bi-directional many-to-one association to ScopeType
	@ManyToOne
	@JoinColumn(name="scope_type_id")
	private ScopeType scopeType;

	//bi-directional many-to-one association to CampaignAttachment
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "campaign_attachment", 
      joinColumns = @JoinColumn(name = "campaign_id"), 
      inverseJoinColumns = @JoinColumn(name = "attachment_id"))
	//@JsonManagedReference(value="campaign-attachment")
	private Set<Attachment> attachments;

	//bi-directional many-to-one association to CampaignTag
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
	@JoinTable(name = "campaign_tag", 
      joinColumns = @JoinColumn(name = "campaign_id", referencedColumnName="campaign_id"), 
      inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="tag_id"))
	//@JsonManagedReference(value="campaign-tag")
	private Set<Tag> tags;

	
	
	
	
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name = "campaign_action", 
      joinColumns = @JoinColumn(name = "campaign_id", referencedColumnName="campaign_id", insertable=true, updatable=true ), 
      inverseJoinColumns = @JoinColumn(name = "action_id", referencedColumnName="action_id", insertable=true, updatable=true))
	@JsonIgnore
	private List<Action> actions = new ArrayList<Action>(0);
    
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy = "campaigns")
	@JsonIgnore
	private List<Company> companies;

	//bi-directional many-to-one association to CampaignContact
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy = "campaigns")
	@JsonIgnore
	private List<Contact> contacts;
	
	
	
	
	
	
	
	
	
	public Campaign() {
	}

	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getActualCompletionDate() {
		return this.actualCompletionDate;
	}

	public void setActualCompletionDate(Date actualCompletionDate) {
		this.actualCompletionDate = actualCompletionDate;
	}

	public String getActualValuation() {
		return this.actualValuation;
	}

	public void setActualValuation(String actualValuation) {
		this.actualValuation = actualValuation;
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

	public boolean isRestrictedToOwner() {
		return this.isRestrictedToOwner;
	}

	public void setRestrictedToOwner(boolean isRestrictedToOwner) {
		this.isRestrictedToOwner = isRestrictedToOwner;
	}

	public Date getTargetCompletionDate() {
		return this.targetCompletionDate;
	}

	public void setTargetCompletionDate(Date targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}

	public String getTargetValuation() {
		return this.targetValuation;
	}

	public void setTargetValuation(String targetValuation) {
		this.targetValuation = targetValuation;
	}

	public CampaignClassificationType getClassificationType() {
		return this.classificationType;
	}

	public void setCampaignClassificationType(CampaignClassificationType classificationType) {
		this.classificationType = classificationType;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public ScopeType getScopeType() {
		return this.scopeType;
	}

	public void setScopeType(ScopeType scopeType) {
		this.scopeType = scopeType;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Set<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public int compareTo(Campaign o) {
		if(! o.getCampaignId().equals(this.getCampaignId())) {
			System.out.println("dfm condition 1");
			return o.getCampaignId().compareTo(this.getCampaignId());
		} else if(! o.getName().equals(this.getName())) {
			System.out.println("dfm condition 2");
			return o.getName().compareTo(this.getName());
		} else {
			return o.getDescription().compareTo(this.getDescription());
		}
	}	
	
}