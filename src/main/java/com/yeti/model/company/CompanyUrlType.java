package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the company_url_type database table.
 * 
 */
@Entity
@Table(name="company_url_type")
@NamedQuery(name="CompanyUrlType.findAll", query="SELECT c FROM CompanyUrlType c")
public class CompanyUrlType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_url_type_id")
	private String urlTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="company_url_type_create_date", insertable=false, updatable=false)
	private Date createDate;

	@Column(name="company_url_type_description")
	private String description;

	@Column(name="company_url_type_name")
	private String name;

	public CompanyUrlType() {
	}

	public String getUrlTypeId() {
		return this.urlTypeId;
	}

	public void setUrlTypeId(String urlTypeId) {
		this.urlTypeId = urlTypeId;
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