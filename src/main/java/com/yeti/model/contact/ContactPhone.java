package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the contact_phone database table.
 * 
 */
@Entity
@Table(name="contact_phone")
@NamedQuery(name="ContactPhone.findAll", query="SELECT c FROM ContactPhone c")
public class ContactPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_phone_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer phoneId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_phone_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createDate;

	@Column(name="contact_phone_description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_phone_last_modified_date", insertable=false, updatable=false)
	private Date lastModifiedDate;

	@Column(name="contact_phone_value")
	private String phoneValue;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contact_id", referencedColumnName="contact_id", unique=true)
	@JsonBackReference(value="contact-phone")
	private Contact contact;

	//bi-directional many-to-one association to ContactPhoneType
	@ManyToOne
	@JoinColumn(name="contact_phone_type_id")
	private ContactPhoneType phoneType;

	public ContactPhone() {
	}

	public Integer getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
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

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getPhoneValue() {
		return this.phoneValue;
	}

	public void setPhoneValue(String phoneValue) {
		this.phoneValue = phoneValue;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContactPhoneType getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(ContactPhoneType phoneType) {
		this.phoneType = phoneType;
	}

}