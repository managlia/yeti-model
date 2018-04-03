package com.yeti.model.util;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The persistent class for the audit_log_details database table.
 * 
 */
@Entity
@Table(name="audit_log_details")
@NamedQuery(name="AuditLogDetail.findAll", query="SELECT a FROM AuditLogDetail a")
public class AuditLogDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_log_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer auditLogId;

	@Lob
	@Column(name="audit_lot_details_after")
	private String auditLotDetailsAfter;

	@Lob
	@Column(name="audit_lot_details_before")
	private String auditLotDetailsBefore;

	//bi-directional one-to-one association to AuditLog
	@OneToOne
	@JoinColumn(name="audit_log_id")
	private AuditLog auditLog;

	public AuditLogDetail() {
	}

	public Integer getAuditLogId() {
		return this.auditLogId;
	}

	public void setAuditLogId(Integer auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getAuditLotDetailsAfter() {
		return this.auditLotDetailsAfter;
	}

	public void setAuditLotDetailsAfter(String auditLotDetailsAfter) {
		this.auditLotDetailsAfter = auditLotDetailsAfter;
	}

	public String getAuditLotDetailsBefore() {
		return this.auditLotDetailsBefore;
	}

	public void setAuditLotDetailsBefore(String auditLotDetailsBefore) {
		this.auditLotDetailsBefore = auditLotDetailsBefore;
	}

	public AuditLog getAuditLog() {
		return this.auditLog;
	}

	public void setAuditLog(AuditLog auditLog) {
		this.auditLog = auditLog;
	}

}