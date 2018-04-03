package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the company_classification_type database table.
 * 
 */
@Entity
@Table(name="company_classification_type")
@NamedQuery(name="CompanyClassificationType.findAll", query="SELECT c FROM CompanyClassificationType c")
public class CompanyClassificationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_classification_type_id")
	private String classificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_classification_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date createDate;

	@Column(name="company_classification_type_description")
	private String description;

	@Column(name="company_classification_type_name")
	private String name;

	public CompanyClassificationType() {
	}

	public String getClassificationTypeId() {
		return this.classificationTypeId;
	}

	public void setClassificationTypeId(String classificationTypeId) {
		this.classificationTypeId = classificationTypeId;
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