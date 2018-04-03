package com.yeti.model.contact;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the contact_title_type database table.
 * 
 */
@Entity
@Table(name="contact_title_type")
@NamedQuery(name="ContactTitleType.findAll", query="SELECT c FROM ContactTitleType c")
public class ContactTitleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_title_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer contactTitleTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_title_type_create_date")
	private Date createDate;

	@Column(name="contact_title_type_description")
	private String description;

	@Column(name="contact_title_type_name")
	private String name;

	public ContactTitleType() {
	}

	public Integer getContactTitleTypeId() {
		return this.contactTitleTypeId;
	}

	public void setContactTitleTypeId(Integer contactTitleTypeId) {
		this.contactTitleTypeId = contactTitleTypeId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

}