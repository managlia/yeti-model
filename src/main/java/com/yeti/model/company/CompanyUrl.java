package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;


/**
 * The persistent class for the company_url database table.
 * 
 */
@Entity
@Table(name="company_url")
@NamedQuery(name="CompanyUrl.findAll", query="SELECT c FROM CompanyUrl c")
public class CompanyUrl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_url_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer urlId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_url_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createDate;

	@Column(name="company_url_description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_url_last_modified_date", insertable=false, updatable=false)
	private Date lastModifiedDate;

	@Column(name="company_url_value")
	private String urlValue;

	//bi-directional many-to-one association to Company
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id", referencedColumnName="company_id", unique=true)
	@JsonBackReference(value="company-url")
	private Company company;

	//bi-directional many-to-one association to CompanyUrlType
	@ManyToOne
	@JoinColumn(name="company_url_type_id")
	private CompanyUrlType urlType;

	public CompanyUrl() {
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

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyUrlType getUrlType() {
		return this.urlType;
	}

	public void setUrlType(CompanyUrlType urlType) {
		this.urlType = urlType;
	}

}