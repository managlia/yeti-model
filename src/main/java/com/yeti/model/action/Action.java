package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.ColumnTransformer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.company.Company;
import com.yeti.model.contact.Contact;
import com.yeti.model.general.ScopeType;
import com.yeti.model.general.Tag;
import com.yeti.util.UpdatableBCrypt;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the action database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="action")
@NamedQueries({
	@NamedQuery(
		name="Action.findAll", 
		query="SELECT a FROM Action a WHERE (a.scopeType.scopeTypeId = 'PA') "
				+ "or "
				+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
				+ "or "
				+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in (:teamList) )"
				
		),
	@NamedQuery(
		name="Action.exists", 
		query="SELECT case when (count(*) > 0) then true else false end "
			+ "FROM Action a WHERE a.actionId = :actionId "
			+ "AND ( (a.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in (:teamList) ) )"
		),
	@NamedQuery(
		name="Action.findOne", 
		query="SELECT a FROM Action a WHERE a.actionId = :actionId "
			+ "AND ( (a.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in (:teamList) ) )"
		)
})
public class Action extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_id", insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@ColumnTransformer(  read="xxxx", 
						 write="xxxx")
	private Integer actionId;

	@Column(name="action_active")
	private boolean isActive;

	@Column(name="action_actual_completion_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date actualCompletionDate;

	@Column(name="action_create_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date createDate;

	@Column(name="action_deactivation_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date deactivationDate;

	@Column(name="action_description")
	private String description;

	@Column(name="action_last_modified_date", insertable=false, updatable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date lastModifiedDate;

	@Column(name="action_name")
	private String name;

	@Column(name="action_restrict_to_owner")
	private boolean restrictedToOwner;

	@Column(name="action_target_completion_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date targetCompletionDate;

	@Column(name="action_target_completion_date_end")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date targetCompletionDateEnd;

	@Column(name="action_parent_action_id")
	private Integer parentActionId;
	
	@Column(name="action_parent_campaign_id")
	private Integer parentCampaignId;

	//bi-directional many-to-one association to ActionClassificationType
	@ManyToOne
	@JoinColumn(name="action_classification_type_id", nullable = true)
	private ActionClassificationType classificationType;

	
	//bi-directional many-to-one association to ActionClassificationType
	@ManyToOne
	@JoinColumn(name="action_classification_other_type_id", nullable = true)
	private ActionClassificationOtherType classificationOtherType;
	
	@Column(name="action_owner_id")
	private Integer ownerId;

	//bi-directional many-to-one association to ScopeType
	@ManyToOne
	@JoinColumn(name="scope_type_id", nullable = true)
	private ScopeType scopeType;
	
	@Column(name="team_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer teamId;	
	
	@Column(name="action_importance")
	private Integer importance;	

	@Column(name="action_difficulty")
	private Integer difficulty;	
	
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
	
	@ManyToMany
	@JoinTable(name = "action_tag", 
      joinColumns = @JoinColumn(name = "action_id", referencedColumnName="action_id"), 
      inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="tag_id"))
	private Set<Tag> tags = new HashSet<Tag>();
	
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

	public Date getTargetCompletionDateEnd() {
		return targetCompletionDateEnd;
	}

	public void setTargetCompletionDateEnd(Date targetCompletionDateEnd) {
		this.targetCompletionDateEnd = targetCompletionDateEnd;
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

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getImportance() {
		return importance;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public List<ActionAction> getActionChildren() {
		return this.actionChildren;
	}

	public void setActionChildren(List<ActionAction> actionChildren) {
		this.actionChildren = actionChildren;
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
	
	public ActionClassificationOtherType getClassificationOtherType() {
		return classificationOtherType;
	}

	public void setClassificationOtherType(ActionClassificationOtherType classificationOtherType) {
		this.classificationOtherType = classificationOtherType;
	}
	
}