package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yeti.model.action.Action;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.company.Company;
import com.yeti.model.general.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer contactId;

	@Column(name="contact_active")
	private boolean isActive;

	@Column(name="contact_email_address")
	private String contactEmailAddress;

	@Column(name="contact_first_name")
	private String firstName;

	@Column(name="contact_last_name")
	private String lastName;

	// included for transportation to/from the email system but not stored in its own db field
	@JsonInclude()
	@Transient
	private String emailRecipientIndicator;
	
	@Column(name="contact_description")
	private String description;

	@CreationTimestamp
	@Column(name="contact_create_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date createDate;

	@Column(name="contact_deactivation_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date deactivationDate;

	@Column(name="contact_last_modified_date", insertable=false, updatable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date lastModifiedDate;

	@Column(name="contact_dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date dob;

	
	
	
	//bi-directional many-to-one association to ContactUrl
	@OneToMany(mappedBy="contact", cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference(value="contact-url")
	private List<ContactUrl> urls;

	//bi-directional many-to-one association to ContactPhone
	@OneToMany(mappedBy="contact", cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference(value="contact-phone")
	private List<ContactPhone> phones;
	
	//bi-directional many-to-one association to ContactAddress
	@OneToMany(mappedBy="contact", cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference(value="contact-address")
	private List<ContactAddress> addresses;

	
	
	
	@ManyToMany
	@JoinTable(name = "contact_tag", 
      joinColumns = @JoinColumn(name = "contact_id", referencedColumnName="contact_id" ), 
      inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="tag_id" ))
	private Set<Tag> tags = new HashSet<Tag>();

	//bi-directional many-to-one association to ContactTeam
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy = "contacts")
	@JsonIgnore
	private List<Team> teams;
	
	
	@Column(name="company_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer companyId;
	
	
	@ManyToOne
	@JoinColumn(name="company_id", insertable=false, updatable=false)
	@JsonBackReference(value="company-contacts")
	private Company company;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name = "campaign_contact", 
      joinColumns = @JoinColumn(name = "contact_id", referencedColumnName="contact_id", insertable=true, updatable=true ), 
      inverseJoinColumns = @JoinColumn(name = "campaign_id", referencedColumnName="campaign_id", insertable=true, updatable=true))
	@JsonIgnore
	private List<Campaign> campaigns = new ArrayList<Campaign>(0);
    
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name = "action_contact", 
      joinColumns = @JoinColumn(name = "contact_id", referencedColumnName="contact_id", insertable=true, updatable=true ), 
      inverseJoinColumns = @JoinColumn(name = "action_id", referencedColumnName="action_id", insertable=true, updatable=true))
	@JsonIgnore
	private List<Action> actions = new ArrayList<Action>(0);

    
    
    
    
	//bi-directional many-to-one association to ContactClassificationType
	@ManyToOne
	@JoinColumn(name="contact_classification_type_id")
	private ContactClassificationType classificationType;

	//bi-directional many-to-one association to ContactTitleType
	@ManyToOne
	@JoinColumn(name="contact_title_type_id")
	private ContactTitleType titleType;

	public Contact() {
	}

	public Integer getContactId() {
		return this.contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmailRecipientIndicator() {
		return emailRecipientIndicator;
	}

	public void setEmailRecipientIndicator(String emailRecipientIndicator) {
		this.emailRecipientIndicator = emailRecipientIndicator;
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

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContactEmailAddress() {
		return this.contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public ContactClassificationType getClassificationType() {
		return this.classificationType;
	}

	public void setClassificationType(ContactClassificationType classificationType) {
		this.classificationType = classificationType;
	}

	public ContactTitleType getTitleType() {
		return this.titleType;
	}

	public void setTitleType(ContactTitleType titleType) {
		this.titleType = titleType;
	}

	public List<ContactAddress> getAddresses() {
		if( this.addresses == null ) {
			this.addresses = new ArrayList<ContactAddress>();
		}
		return this.addresses;
	}

	public void setAddresses(List<ContactAddress> addresses) {
		this.getAddresses().clear();
	    if (addresses != null) {
	        this.addresses.addAll(addresses);
	    }
	}

	public Set<Tag> getTags() {
		if( this.tags == null ) {
			this.tags = new HashSet<Tag>();
		}
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.getTags().clear();
	    if (tags != null) {
	        this.tags.addAll(tags);
	    }
	}

	public List<ContactUrl> getUrls() {
		if( this.urls == null ) {
			this.urls = new ArrayList<ContactUrl>();
		}
		return this.urls;
	}

	public void setUrls(List<ContactUrl> urls) {
		this.getUrls().clear();
	    if (urls != null) {
	        this.urls.addAll(urls);
	    }
	}

	public List<Team> getTeams() {
		if( this.teams == null ) {
			this.teams = new ArrayList<Team>();
		}
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.getTeams().clear();
	    if (teams != null) {
	        this.teams.addAll(teams);
	    }
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<ContactPhone> getPhones() {
		if( this.phones == null ) {
			this.phones = new ArrayList<ContactPhone>();
		}
		return this.phones;
	}

	public void setPhones(List<ContactPhone> phones) {
		this.getPhones().clear();
	    if (phones != null) {
	        this.phones.addAll(phones);
	    }
	}
}