package com.yeti.model.general;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yeti.model.action.Action;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.company.Company;
import com.yeti.model.contact.Contact;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
//@Audited
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tag_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer tagId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="tag_create_date", insertable=false, updatable=false)
	private Date createDate;

	@Column(name="tag_creator_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer creatorId;

	@Column(name="tag_description")
	private String description;

	@Column(name="tag_name")
	private String name;

	@ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Company> companies;
	
	@ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Contact> contacts;

	@ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Campaign> campaigns;

	@ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Action> actions;
	
	public Tag() {
	}

	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(Set<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
}