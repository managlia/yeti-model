package com.yeti.model.report;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@Table(name="report")
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="report_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer reportId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="report_create_date")
	private Date createDate;

	@Column(name="report_description")
	private String description;

	@Column(name="report_generate_automatically")
	private boolean reportGenerateAutomatically;

	@Column(name="report_generate_on")
	private boolean reportGenerateOn;

	@Column(name="report_generation_frequency")
	private String reportGenerationFrequency;

	@Column(name="report_name")
	private String name;

	@Column(name="report_creator_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer reportCreatorId;

	//bi-directional many-to-one association to ReportDefinitionElement
	@OneToMany(mappedBy="report")
	private List<ReportDefinitionElement> reportDefinitionElements;

	//bi-directional many-to-one association to ReportRepository
	@OneToMany(mappedBy="report")
	private List<ReportRepository> reportRepositories;

	public Report() {
	}

	public Integer getReportId() {
		return this.reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
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

	public boolean isReportGenerateAutomatically() {
		return this.reportGenerateAutomatically;
	}

	public void setReportGenerateAutomatically(boolean reportGenerateAutomatically) {
		this.reportGenerateAutomatically = reportGenerateAutomatically;
	}

	public boolean isReportGenerateOn() {
		return this.reportGenerateOn;
	}

	public void setReportGenerateOn(boolean reportGenerateOn) {
		this.reportGenerateOn = reportGenerateOn;
	}

	public String getReportGenerationFrequency() {
		return this.reportGenerationFrequency;
	}

	public void setReportGenerationFrequency(String reportGenerationFrequency) {
		this.reportGenerationFrequency = reportGenerationFrequency;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReportCreatorId() {
		return this.reportCreatorId;
	}

	public void setReportCreatorId(Integer reportCreatorId) {
		this.reportCreatorId = reportCreatorId;
	}

	public List<ReportDefinitionElement> getReportDefinitionElements() {
		return this.reportDefinitionElements;
	}

	public void setReportDefinitionElements(List<ReportDefinitionElement> reportDefinitionElements) {
		this.reportDefinitionElements = reportDefinitionElements;
	}

	public List<ReportRepository> getReportRepositories() {
		return this.reportRepositories;
	}

	public void setReportRepositories(List<ReportRepository> reportRepositories) {
		this.reportRepositories = reportRepositories;
	}

}