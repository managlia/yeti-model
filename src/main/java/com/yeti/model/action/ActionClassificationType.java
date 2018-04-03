package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yeti.model.action.validators.ActionClassificationTypeListener;

import java.util.Date;


/**
 * The persistent class for the action_classification_type database table.
 * 
 */
@Entity
@Table(name="action_classification_type")
@NamedQuery(name="ActionClassificationType.findAll", query="SELECT a FROM ActionClassificationType a")
@EntityListeners(ActionClassificationTypeListener.class)
public class ActionClassificationType extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_classification_type_id")
	@Size(min=2, max=2)
    @NotNull
	private String actionClassificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_classification_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date createDate;

	@Column(name="action_classification_type_description")
	@Size(min=2, max=255)
    @NotNull
	private String description;

	@Column(name="action_classification_type_name")
	@Size(min=2, max=50)
    @NotNull
	private String name;

	public ActionClassificationType() {
	}

	public String getActionClassificationTypeId() {
		return this.actionClassificationTypeId;
	}

	public void setActionClassificationTypeId(String actionClassificationTypeId) {
		this.actionClassificationTypeId = actionClassificationTypeId;
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

	@Override
	public String toString() {
		return "ActionClassificationType [actionClassificationTypeId=" + actionClassificationTypeId + ", createDate="
				+ createDate + ", description=" + description + ", name=" + name + "]";
	}

	
	
}