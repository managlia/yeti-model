package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the action_classification_other_type database table.
 * 
 */
@Entity
@Table(name="action_classification_other_type")
@NamedQuery(name="ActionClassificationOtherType.findAll", query="SELECT c FROM ActionClassificationOtherType c")
public class ActionClassificationOtherType extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_classification_other_type_id", insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer actionClassificationOtherTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_classification_other_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date createDate;

	@Column(name="action_classification_other_type_description")
	private String description;

	@Column(name="action_classification_other_type_name")
	private String name;

	public ActionClassificationOtherType() {
	}

	public Integer getActionClassificationOtherTypeId() {
		return this.actionClassificationOtherTypeId;
	}

	public void setActionClassificationOtherTypeId(Integer actionClassificationOtherTypeId) {
		this.actionClassificationOtherTypeId = actionClassificationOtherTypeId;
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