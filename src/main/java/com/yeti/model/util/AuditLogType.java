package com.yeti.model.util;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The persistent class for the audit_log_type database table.
 * 
 */
@Entity
@Table(name="audit_log_type")
@NamedQuery(name="AuditLogType.findAll", query="SELECT a FROM AuditLogType a")
public class AuditLogType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_log_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer auditLogTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_log_type_create_date")
	private Date createDate;

	@Column(name="audit_log_type_description")
	private String description;

	@Column(name="audit_log_type_name")
	private String auditLogTypeName;

	public AuditLogType() {
	}

	public Integer getAuditLogTypeId() {
		return this.auditLogTypeId;
	}

	public void setAuditLogTypeId(Integer auditLogTypeId) {
		this.auditLogTypeId = auditLogTypeId;
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

	public String getAuditLogTypeName() {
		return this.auditLogTypeName;
	}

	public void setAuditLogTypeName(String auditLogTypeName) {
		this.auditLogTypeName = auditLogTypeName;
	}

}