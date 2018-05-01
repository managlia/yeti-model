package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the company_phone_type database table.
 * 
 */
@Entity
@Table(name="company_phone_type")
@NamedQuery(name="CompanyPhoneType.findAll", query="SELECT c FROM CompanyPhoneType c")
public class CompanyPhoneType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_phone_type_id")
	private String phoneTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="company_phone_type_create_date", insertable=false, updatable=false)
	private Date createDate;

	@Column(name="company_phone_type_description")
	private String description;

	@Column(name="company_phone_type_name")
	private String name;

	public CompanyPhoneType() {
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