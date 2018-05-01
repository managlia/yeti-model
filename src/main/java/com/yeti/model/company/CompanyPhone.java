package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the company_phone database table.
 * 
 */
@Entity
@Table(name="company_phone")
@NamedQuery(name="CompanyPhone.findAll", query="SELECT c FROM CompanyPhone c")
public class CompanyPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_phone_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer phoneId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_phone_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createDate;

	@Column(name="company_phone_description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_phone_last_modified_date", insertable=false, updatable=false)
	private Date lastModifiedDate;

	@Column(name="company_phone_value")
	private String phoneValue;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id", referencedColumnName="company_id", unique=true)
	@JsonBackReference(value="company-phone")
	private Company company;

	//bi-directional many-to-one association to CompanyPhoneType
	@ManyToOne
	@JoinColumn(name="company_phone_type_id")
	private CompanyPhoneType phoneType;

	public CompanyPhone() {
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

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyPhoneType getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(CompanyPhoneType phoneType) {
		this.phoneType = phoneType;
	}

}