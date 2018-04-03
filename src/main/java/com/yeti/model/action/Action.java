package com.yeti.model.action;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.company.Company;
import com.yeti.model.contact.Contact;
import com.yeti.model.general.Attachment;
import com.yeti.model.general.ScopeType;
import com.yeti.model.general.Tag;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the action database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_id", insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer actionId;

	@Column(name="action_active")
	private boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_actual_completion_date")
	private Date actualCompletionDate;

	@Column(name="action_actual_valuation")
	private String actualValuation;

	@CreationTimestamp
	@Column(name="action_create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_deactivation_date")
	private Date deactivationDate;

	@Column(name="action_description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_last_modified_date", insertable=false, updatable=false)
	//	@UpdateTimestamp
	private Date lastModifiedDate;

	@Column(name="action_name")
	private String name;

	@Column(name="action_restrict_to_owner")
	private boolean restrictedToOwner;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_target_completion_date")
	private Date targetCompletionDate;

	@Column(name="action_target_valuation")
	private String targetValuation;

	@Column(name="action_parent_action_id")
	private Integer parentActionId;
	
	@Column(name="action_parent_campaign_id")
	private Integer parentCampaignId;

	//bi-directional many-to-one association to ActionClassificationType
	@ManyToOne
	@JoinColumn(name="action_classification_type_id", nullable = true)
	private ActionClassificationType classificationType;

	@Column(name="action_owner_id")
	private Integer ownerId;

	//bi-directional many-to-one association to ScopeType
	@ManyToOne
	@JoinColumn(name="scope_type_id", nullable = true)
	private ScopeType scopeType;

/*
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "action_action", 
      joinColumns = @JoinColumn(name = "parent_action_id"), 
      inverseJoinColumns = @JoinColumn(name = "child_action_id"))
	private Set<Action> actionChildren;
*/
	
	//bi-directional many-to-one association to ActionAction
	@OneToMany
	@JoinColumn(name = "parent_action_id")
	@RestResource(path = "actionChildren", rel="children")
	@JsonManagedReference(value="action-action")
	private List<ActionAction> actionChildren;	
	
	//bi-directional many-to-one association to Attachment
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "action_attachment", 
      joinColumns = @JoinColumn(name = "action_id"), 
      inverseJoinColumns = @JoinColumn(name = "attachment_id"))
	//@JsonManagedReference(value="action-attachment")
	private Set<Attachment> attachments;

	//bi-directional many-to-one association to ActionTag
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
	@JoinTable(name = "action_tag", 
      joinColumns = @JoinColumn(name = "action_id", referencedColumnName="action_id"), 
      inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="tag_id"))
	//@JsonManagedReference(value="action-tag")
	private Set<Tag> tags;
	
	
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy = "actions")
	@JsonIgnore
	private List<Contact> contacts;
	
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy = "actions")
	@JsonIgnore
	private List<Campaign> campaigns;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy = "actions")
	@JsonIgnore
	private List<Company> companies;

    //Used for exchange of reading/writing to external calendar system
	@JsonInclude()
	@Transient
	private List<CalendarEvent> calendarEvents;
	
	public Action() {
	}

	public Integer getActionId () {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public boolean isDeleteable() {
		boolean deleteable = 
			CollectionUtils.isEmpty(actionChildren) && 
			CollectionUtils.isEmpty(contacts) && 
			CollectionUtils.isEmpty(campaigns) && 
			CollectionUtils.isEmpty(companies);
		return deleteable;
	}
	
	public boolean getActive() {
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
		return this.restrictedToOwner;
	}

	public void setRestrictedToOwner(boolean restrictedToOwner) {
		this.restrictedToOwner = restrictedToOwner;
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

	public Integer getParentActionId() {
		return this.parentActionId;
	}

	public void setParentActionId(Integer parentActionId) {
		this.parentActionId = parentActionId;
	}

	public Integer getParentCampaignId() {
		return this.parentCampaignId;
	}

	public void setParentCampaignId(Integer parentCampaignId) {
		this.parentCampaignId = parentCampaignId;
	}
	
	public ActionClassificationType getClassificationType() {
		return this.classificationType;
	}

	public void setClassificationType(ActionClassificationType classificationType) {
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

	public List<ActionAction> getActionChildren() {
		return this.actionChildren;
	}

	public void setActionChildren(List<ActionAction> actionChildren) {
		this.actionChildren = actionChildren;
	}

	public Set<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Company> getCompanies() {
		return companies;
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

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public List<CalendarEvent> getCalendarEvents() {
		return calendarEvents;
	}

	public void setCalendarEvents(List<CalendarEvent> calendarEvents) {
		this.calendarEvents = calendarEvents;
	}
	
	
	@Override
	public String toString() {
		return "Action [actionId=" + actionId + ", isActive=" + isActive  + ", isDeleteable=" + this.isDeleteable() + ", actualCompletionDate="
				+ actualCompletionDate + ", actualValuation=" + actualValuation + ", createDate=" + createDate
				+ ", deactivationDate=" + deactivationDate + ", description=" + description + ", lastModifiedDate="
				+ lastModifiedDate + ", name=" + name + ", restrictedToOwner=" + restrictedToOwner
				+ ", targetCompletionDate=" + targetCompletionDate + ", targetValuation=" + targetValuation
				+ ", parentActionId=" + parentActionId + ", parentCampaignId=" + parentCampaignId
				+ ", classificationType=" + classificationType + ", ownerId=" + ownerId + ", scopeType=" + scopeType
				+ ", actionChildren=" + actionChildren + ", attachments=" + attachments + ", tags=" + tags
				+ ", contacts=" + contacts + ", campaigns=" + campaigns + ", companies=" + companies + "]";
	}
	
	
	public void copyActionForSubclass(Action action) {
		this.setActive(action.getActive());
		this.setActualCompletionDate(action.getActualCompletionDate());
		this.setActualValuation(action.getActualValuation());
		this.setTargetCompletionDate(action.getTargetCompletionDate());
		this.setTargetValuation(action.getTargetValuation());
		this.setDescription(action.getDescription());
		this.setName(action.getName());
		this.setOwnerId(action.getOwnerId());
		this.setParentActionId(action.getParentActionId());
		this.setParentCampaignId(action.getParentCampaignId());
		this.setTags(action.getTags());
		this.setClassificationType(action.getClassificationType());
		this.setScopeType(action.getScopeType());
		this.setCalendarEvents(action.getCalendarEvents());
	}

}