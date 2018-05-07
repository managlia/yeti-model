package com.yeti.model.host;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yeti.model.contact.Contact;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer contactId;	
	
	@Column(name="email_system")
	@JsonIgnore
	private String emailSystem;

	@Column(name="user_email_login")
	@JsonIgnore
	private String emailAddress;

	@Column(name="user_email_history_id")
	@JsonIgnore
	private BigInteger userEmailHistoryId;

	@Column(name="user_external_id")
	@JsonIgnore
	private String externalId;

	@Column(name="user_login")
	@JsonIgnore
	private String username;

	@Column(name="user_password")
	@JsonIgnore
	private String password;

	@OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Role> roles;

	public User() {
	}

	public String getEmailSystem() {
		return this.emailSystem;
	}

	public void setEmailSystem(String emailSystem) {
		this.emailSystem = emailSystem;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public BigInteger getUserEmailHistoryId() {
		return this.userEmailHistoryId;
	}

	public void setUserEmailHistoryId(BigInteger userEmailHistoryId) {
		this.userEmailHistoryId = userEmailHistoryId;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		if( this.roles == null ) {
			this.roles = new ArrayList<Role>();
		}
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}