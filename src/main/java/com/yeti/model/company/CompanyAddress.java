package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;

/**
 * The persistent class for the company_address database table.
 * 
 */
@Entity
@Table(name="company_address")
@NamedQuery(name="CompanyAddress.findAll", query="SELECT c FROM CompanyAddress c")
public class CompanyAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer addressId;

	@Column(name="company_address_1")
	private String address1;

	@Column(name="company_address_2")
	private String address2;

	@Column(name="company_city")
	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_city_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_city_last_modified_date", insertable=false, updatable=false)
	private Date lastModifiedDate;

	@Column(name="company_country")
	private String countryId;

	@Column(name="company_postal_code")
	private String postalCode;

	@Column(name="company_state")
	private String stateId;

	//bi-directional many-to-one association to CompanyAddressType
	@ManyToOne
	@JoinColumn(name="company_address_type_id")
	private CompanyAddressType addressType;

	//bi-directional many-to-one association to Company
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id", referencedColumnName="company_id", unique=true)
	@JsonBackReference(value="company-address")
	private Company company;

	public CompanyAddress() {
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

	public CompanyAddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(CompanyAddressType addressType) {
		this.addressType = addressType;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}