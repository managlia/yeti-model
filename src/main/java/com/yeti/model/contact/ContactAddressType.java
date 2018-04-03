package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the contact_address_type database table.
 * 
 */
@Entity
@Table(name="contact_address_type")
@NamedQuery(name="ContactAddressType.findAll", query="SELECT c FROM ContactAddressType c")
public class ContactAddressType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_address_type_id")
	private String addressTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="contact_address_type_create_date", insertable=false, updatable=false)
	private Date createDate;

	@Column(name="contact_address_type_description")
	private String description;

	@Column(name="contact_address_type_name")
	private String name;

	public ContactAddressType() {
	}

	public String getAddressTypeId() {
		return this.addressTypeId;
	}

	public void setAddressTypeId(String addressTypeId) {
		this.addressTypeId = addressTypeId;
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