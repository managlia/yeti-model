package com.yeti.model.contact;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="team")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer teamId;

	@Column(name="team_name")
	private String name;
	
	@Column(name="team_description")
	private String description;

	@Column(name="team_active")
	private boolean isActive;

	@Column(name="team_creator_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer creatorId;
	
	@CreationTimestamp
	@Column(name="team_create_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="team_last_modified_date", insertable=false, updatable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date lastModifiedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="team_deactivation_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date deactivationDate;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name = "contact_team", 
      joinColumns = @JoinColumn(name = "team_id", referencedColumnName="team_id", insertable=true, updatable=true ), 
      inverseJoinColumns = @JoinColumn(name = "contact_id", referencedColumnName="contact_id", insertable=true, updatable=true))
	@JsonIgnore
	private List<Contact> contacts = new ArrayList<Contact>(0);
    
	@JsonInclude()
	@Transient
	private String matchTerm;

	@JsonInclude()
	@Transient
	private String entiyType;

	@JsonInclude()
	@Transient
	private boolean deactivatable;
	
	
	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getDeactivationDate() {
		return deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getMatchTerm() {
		return matchTerm;
	}

	public void setMatchTerm(String matchTerm) {
		this.matchTerm = matchTerm;
	}

	public String getEntiyType() {
		return entiyType;
	}

	public void setEntiyType(String entiyType) {
		this.entiyType = entiyType;
	}

	public boolean getDeactivatable() {
		return deactivatable;
	}

	public void setDeactivatable(boolean deactivatable) {
		this.deactivatable = deactivatable;
	}
}
