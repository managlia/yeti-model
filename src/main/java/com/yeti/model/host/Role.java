package com.yeti.model.host;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role {

	public Role(String name) {
		setName(name);
	}

	public Role() {
	}
	
	@Id
	@Column(name="role_contact_id")
	@JsonIgnore
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer roleContactId;
	
	@ManyToOne
	@JoinColumn(name="contact_id")
	@JsonIgnore
	private User user;
	
	@Column(name="role_name")
	private String name;

	public Integer getRoleContactId() {
		return roleContactId;
	}

	public void setRoleContactId(Integer roleContactId) {
		this.roleContactId = roleContactId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
