package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_external_id")
	private String externalId;

	@Column(name="product_description")
	private String description;

	@Lob
	@Column(name="product_last_retrieved_value", insertable=false, updatable=false)
	private String lastRetrievedValue;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="product_last_update_date", insertable=false, updatable=false)
	private Date lastUpdateDate;

	@Column(name="product_name")
	private String name;

	public Product() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getLastRetrievedValue() {
		return this.lastRetrievedValue;
	}

	public void setLastRetrievedValue(String lastRetrievedValue) {
		this.lastRetrievedValue = lastRetrievedValue;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}