package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the contact_classification_type database table.
 * 
 */
@Entity
@Table(name="contact_classification_type")
@NamedQuery(name="ContactClassificationType.findAll", query="SELECT c FROM ContactClassificationType c")
public class ContactClassificationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_classification_type_id")
	private String classificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_classification_type_create_date")
	@JsonIgnore
	private Date createDate;

	@Column(name="contact_classification_type_description")
	private String description;

	@Column(name="contact_classification_type_name")
	private String name;

	public ContactClassificationType() {
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