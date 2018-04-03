package com.yeti.model.general;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the scope_type database table.
 * 
 */
@Entity
@Table(name="scope_type")
@NamedQuery(name="ScopeType.findAll", query="SELECT s FROM ScopeType s")
public class ScopeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="scope_type_id")
	private String scopeTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="scope_type_create_date", insertable=false, updatable=false)
	private Date createDate;

	@Column(name="scope_type_description")
	private String description;

	@Column(name="scope_type_name")
	private String name;

	public ScopeType() {
	}

	public String getScopeTypeId() {
		return this.scopeTypeId;
	}

	public void setScopeTypeId(String scopeTypeId) {
		this.scopeTypeId = scopeTypeId;
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
		return "ScopeType [scopeTypeId=" + scopeTypeId + ", createDate=" + createDate + ", description=" + description
				+ ", name=" + name + "]";
	}
	
	

}