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
 * The persistent class for the attachment database table.
 * 
 */
@Entity
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="attachment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer attachmentId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="attachment_create_date")
	private Date createDate;

	@Lob
	@Column(name="attachment_file")
	private byte[] attachmentFile;

	@Column(name="attachment_name")
	private String name;

	@Column(name="attachment_path")
	private String attachmentPath;

	@Column(name="attachment_type")
	private String attachmentType;

	@ManyToMany(mappedBy = "attachments")
	@JsonIgnore
	private Set<Company> companies;
	
	@ManyToMany(mappedBy = "attachments")
	@JsonIgnore
	private Set<Contact> contacts;

	@ManyToMany(mappedBy = "attachments")
	@JsonIgnore
	private Set<Campaign> campaigns;

	@ManyToMany(mappedBy = "attachments")
	@JsonIgnore
	private Set<Action> actions;
	
	public Attachment() {
	}

	public Integer getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte[] getAttachmentFile() {
		return this.attachmentFile;
	}

	public void setAttachmentFile(byte[] attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttachmentPath() {
		return this.attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getAttachmentType() {
		return this.attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
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