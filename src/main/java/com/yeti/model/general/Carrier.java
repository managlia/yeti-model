package com.yeti.model.general;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the carrier database table.
 * 
 */
@Entity
@Table(name="carrier")
@NamedQuery(name="Carrier.findAll", query="SELECT c FROM Carrier c")
public class Carrier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="carrier_id")
	private String carrierId;

	@Column(name="carrier_description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="carrier_last_update_date", insertable=false, updatable=false)
	private Date lastUpdateDate;

	@Column(name="carrier_tracking_url")
	private String trackingUrl;

	@Column(name="carrier_url")
	private String carrierUrl;

	public Carrier() {
	}

	public String getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getTrackingUrl() {
		return this.trackingUrl;
	}

	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	public String getCarrierUrl() {
		return this.carrierUrl;
	}

	public void setCarrierUrl(String carrierUrl) {
		this.carrierUrl = carrierUrl;
	}

}