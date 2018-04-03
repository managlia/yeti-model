package com.yeti.model.report;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;


/**
 * The persistent class for the report_repository database table.
 * 
 */
@Entity
@Table(name="report_repository")
@NamedQuery(name="ReportRepository.findAll", query="SELECT r FROM ReportRepository r")
public class ReportRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="report_repository_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer reportRepositoryId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="report_generation_date")
	private Date reportGenerationDate;

	@Lob
	@Column(name="report_value")
	private String reportValue;

	//bi-directional many-to-one association to Report
	@ManyToOne
	@JoinColumn(name="report_id")
	private Report report;

	public ReportRepository() {
	}

	public Integer getReportRepositoryId() {
		return this.reportRepositoryId;
	}

	public void setReportRepositoryId(Integer reportRepositoryId) {
		this.reportRepositoryId = reportRepositoryId;
	}

	public Date getReportGenerationDate() {
		return this.reportGenerationDate;
	}

	public void setReportGenerationDate(Date reportGenerationDate) {
		this.reportGenerationDate = reportGenerationDate;
	}

	public String getReportValue() {
		return this.reportValue;
	}

	public void setReportValue(String reportValue) {
		this.reportValue = reportValue;
	}

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}