package com.yeti.model.search;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CampaignOrAction implements Serializable, Comparable<CampaignOrAction> {
	private static final long serialVersionUID = 1L;

	@Id
	private String matchTerm;

	private String entiyType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer campaignId;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer actionId;
	
	public String getMatchTerm() {
		return matchTerm;
	}

	public void setMatchTerm(String matchTerm) {
		this.matchTerm = matchTerm;
	}

	public String getEntiyType() {
		return entiyType;
	}

	public void setEntiyType(String entiyType) {
		this.entiyType = entiyType;
	}

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	@Override
	public int compareTo(CampaignOrAction o) {
		return o.getMatchTerm().compareTo(this.getMatchTerm());
	}

}
