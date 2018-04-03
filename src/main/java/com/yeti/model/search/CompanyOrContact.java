package com.yeti.model.search;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CompanyOrContact implements Serializable, Comparable<CompanyOrContact> {
	private static final long serialVersionUID = 1L;

	@Id
	private String matchTerm;

	private String entiyType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer companyId;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer contactId;
	
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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	@Override
	public int compareTo(CompanyOrContact o) {
		return o.getMatchTerm().compareTo(this.getMatchTerm());
	}

}
