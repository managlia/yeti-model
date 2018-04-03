package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the order_state_type database table.
 * 
 */
@Entity
@Table(name="order_state_type")
@NamedQuery(name="OrderStateType.findAll", query="SELECT o FROM OrderStateType o")
public class OrderStateType extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_state_type_id")
	private String orderStateTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="order_state_type_create_date", insertable=false, updatable=false)
	private Date createDate;

	@Column(name="order_state_type_description")
	private String description;

	@Column(name="order_state_type_name")
	private String name;

	public OrderStateType() {
	}

	public String getOrderStateTypeId() {
		return this.orderStateTypeId;
	}

	public void setOrderStateTypeId(String orderStateTypeId) {
		this.orderStateTypeId = orderStateTypeId;
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