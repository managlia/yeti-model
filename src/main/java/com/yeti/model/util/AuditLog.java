package com.yeti.model.util;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the audit_log database table.
 * 
 */
@Entity
@Table(name="audit_log")
@NamedQuery(name="AuditLog.findAll", query="SELECT a FROM AuditLog a")
public class AuditLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_log_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer auditLogId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_log_date")
	private Date auditLogDate;

	@Column(name="entity_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer entityId;

	@Column(name="entity_name")
	private String name;

	@Column(name="tranaction_log_actor_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer tranactionLogActorId;

	//bi-directional many-to-one association to AuditLogSectionType
	@ManyToOne
	@JoinColumn(name="audit_log_section_type_id")
	private AuditLogSectionType auditLogSectionType;

	//bi-directional many-to-one association to AuditLogType
	@ManyToOne
	@JoinColumn(name="audit_log_type_id")
	private AuditLogType auditLogType;

	//bi-directional one-to-one association to AuditLogDetail
	@OneToOne(mappedBy="auditLog")
	@JsonIgnore
	private AuditLogDetail auditLogDetail;

	public AuditLog() {
	}

	public Integer getAuditLogId() {
		return this.auditLogId;
	}

	public void setAuditLogId(Integer auditLogId) {
		this.auditLogId = auditLogId;
	}

	public Date getAuditLogDate() {
		return this.auditLogDate;
	}

	public void setAuditLogDate(Date auditLogDate) {
		this.auditLogDate = auditLogDate;
	}

	public Integer getEntityId() {
		return this.entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTranactionLogActorId() {
		return this.tranactionLogActorId;
	}

	public void setTranactionLogActorId(Integer tranactionLogActorId) {
		this.tranactionLogActorId = tranactionLogActorId;
	}

	public AuditLogSectionType getAuditLogSectionType() {
		return this.auditLogSectionType;
	}

	public void setAuditLogSectionType(AuditLogSectionType auditLogSectionType) {
		this.auditLogSectionType = auditLogSectionType;
	}

	public AuditLogType getAuditLogType() {
		return this.auditLogType;
	}

	public void setAuditLogType(AuditLogType auditLogType) {
		this.auditLogType = auditLogType;
	}

	public AuditLogDetail getAuditLogDetail() {
		return this.auditLogDetail;
	}

	public void setAuditLogDetail(AuditLogDetail auditLogDetail) {
		this.auditLogDetail = auditLogDetail;
	}

}