package com.yeti.model.util;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;


/**
 * The persistent class for the audit_log_section_type database table.
 * 
 */
@Entity
@Table(name="audit_log_section_type")
@NamedQuery(name="AuditLogSectionType.findAll", query="SELECT a FROM AuditLogSectionType a")
public class AuditLogSectionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_log_section_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer auditLogSectionTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_log_section_type_create_date")
	private Date createDate;

	@Column(name="audit_log_section_type_description")
	private String description;

	@Column(name="audit_log_section_type_name")
	private String auditLogSectionTypeName;

	public AuditLogSectionType() {
	}

	public Integer getAuditLogSectionTypeId() {
		return this.auditLogSectionTypeId;
	}

	public void setAuditLogSectionTypeId(Integer auditLogSectionTypeId) {
		this.auditLogSectionTypeId = auditLogSectionTypeId;
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

	public String getAuditLogSectionTypeName() {
		return this.auditLogSectionTypeName;
	}

	public void setAuditLogSectionTypeName(String auditLogSectionTypeName) {
		this.auditLogSectionTypeName = auditLogSectionTypeName;
	}

}