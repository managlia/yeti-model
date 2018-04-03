package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the contact_url database table.
 * 
 */
@Entity
@Table(name="contact_url")
@NamedQuery(name="ContactUrl.findAll", query="SELECT c FROM ContactUrl c")
public class ContactUrl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_url_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer urlId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_url_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createDate;

	@Column(name="contact_url_description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_url_last_modified_date", insertable=false, updatable=false)
	private Date lastModifiedDate;

	@Column(name="contact_url_value")
	private String urlValue;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contact_id", referencedColumnName="contact_id", unique=true)
	@JsonBackReference(value="contact-url")
	private Contact contact;

	//bi-directional many-to-one association to ContactUrlType
	@ManyToOne
	@JoinColumn(name="contact_url_type_id")
	private ContactUrlType urlType;

	public ContactUrl() {
	}

	public Integer getUrlId() {
		return this.urlId;
	}

	public void setUrlId(Integer urlId) {
		this.urlId = urlId;
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

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getUrlValue() {
		return this.urlValue;
	}

	public void setUrlValue(String urlValue) {
		this.urlValue = urlValue;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContactUrlType getUrlType() {
		return this.urlType;
	}

	public void setUrlType(ContactUrlType urlType) {
		this.urlType = urlType;
	}

}