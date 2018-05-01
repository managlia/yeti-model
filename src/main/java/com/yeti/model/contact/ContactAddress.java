package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yeti.model.company.Company;

import java.util.Date;

/**
 * The persistent class for the contact_address database table.
 * 
 */
@Entity
@Table(name="contact_address")
@NamedQuery(name="ContactAddress.findAll", query="SELECT c FROM ContactAddress c")
public class ContactAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer addressId;

	@Column(name="contact_address_1")
	private String address1;

	@Column(name="contact_address_2")
	private String address2;

	@Column(name="contact_city")
	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_city_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_city_last_modified_date", insertable=false, updatable=false)
	private Date lastModifiedDate;

	@Column(name="contact_country")
	private String countryId;

	@Column(name="contact_postal_code")
	private String postalCode;

	@Column(name="contact_state")
	private String stateId;

	//bi-directional many-to-one association to ContactAddressType
	@ManyToOne
	@JoinColumn(name="contact_address_type_id")
	private ContactAddressType addressType;

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contact_id", referencedColumnName="contact_id", unique=true)
	@JsonBackReference(value="contact-address")
	private Contact contact;
	
	public ContactAddress() {
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateId() {
		return this.stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public ContactAddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(ContactAddressType addressType) {
		this.addressType = addressType;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "ContactAddress [addressId=" + addressId + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", createDate=" + createDate + ", lastModifiedDate=" + lastModifiedDate
				+ ", countryId=" + countryId + ", postalCode=" + postalCode + ", stateId=" + stateId + ", addressType="
				+ addressType + "]";
	}

}