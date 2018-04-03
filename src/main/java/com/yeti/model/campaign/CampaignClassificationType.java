package com.yeti.model.campaign;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the campaign_classification_type database table.
 * 
 */
@Entity
@Table(name="campaign_classification_type")
@NamedQuery(name="CampaignClassificationType.findAll", query="SELECT c FROM CampaignClassificationType c")
public class CampaignClassificationType extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_classification_type_id", insertable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer campaignClassificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_classification_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date createDate;

	@Column(name="campaign_classification_type_description")
	private String description;

	@Column(name="campaign_classification_type_name", insertable=true, updatable=true)
	private String name;

	public CampaignClassificationType() {
	}

	public Integer getCampaignClassificationTypeId() {
		return this.campaignClassificationTypeId;
	}

	public void setCampaignClassificationTypeId(Integer campaignClassificationTypeId) {
		this.campaignClassificationTypeId = campaignClassificationTypeId;
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