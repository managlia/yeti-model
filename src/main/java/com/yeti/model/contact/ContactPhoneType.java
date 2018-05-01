package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the contact_phone_type database table.
 * 
 */
@Entity
@Table(name="contact_phone_type")
@NamedQuery(name="ContactPhoneType.findAll", query="SELECT c FROM ContactPhoneType c")
public class ContactPhoneType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_phone_type_id")
	private String phoneTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="contact_phone_type_create_date", insertable=false, updatable=false)
	private Date createDate;

	@Column(name="contact_phone_type_description")
	private String description;

	@Column(name="contact_phone_type_name")
	private String name;

	public ContactPhoneType() {
	}

	public String getPhoneTypeId() {
		return this.phoneTypeId;
	}

	public void setPhoneTypeId(String phoneTypeId) {
		this.phoneTypeId = phoneTypeId;
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