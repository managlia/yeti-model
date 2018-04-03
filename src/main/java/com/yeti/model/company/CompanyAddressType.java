package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the company_address_type database table.
 * 
 */
@Entity
@Table(name="company_address_type")
@NamedQuery(name="CompanyAddressType.findAll", query="SELECT c FROM CompanyAddressType c")
public class CompanyAddressType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_address_type_id")	
	private String addressTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_address_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date createDate;

	@Column(name="company_address_type_description")
	private String description;

	@Column(name="company_address_type_name")
	private String name;

	public CompanyAddressType() {
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