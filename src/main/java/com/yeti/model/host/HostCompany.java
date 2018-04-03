package com.yeti.model.host;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yeti.model.company.Company;


/**
 * The persistent class for the host_company database table.
 * 
 */
@Entity
@Table(name="host_company")
@NamedQuery(name="HostCompany.findAll", query="SELECT h FROM HostCompany h")
public class HostCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer companyId;

	//bi-directional one-to-one association to Company
	@OneToOne
	@JoinColumn(name="company_id")
	private Company company;

	public HostCompany() {
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}