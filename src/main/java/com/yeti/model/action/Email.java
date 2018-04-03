package com.yeti.model.action;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yeti.model.contact.Contact;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the email database table.
 * 
 */
@Entity
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email extends Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="email_external_id")
	private String externalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="email_last_retrieved_date")
	private Date lastRetrievedDate;

	@Lob
	@Column(name="email_last_retrieved_valiue")
	// @JsonIgnore
	private String emailDetails;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="email_instance_date")
	private Date instanceDate;

	@Column(name="email_thread_id")
	private String threadId;
	
	@Column(name="email_history_id")
	private BigInteger historyId;
	
	@JsonInclude()
	@Transient
	private List<Contact> recipients;

	/* Fields added for sending an email.
	 * They don't need to be stored in the database since they
	 * will be stored on the email itself.
	 */
	@JsonInclude()
	@Transient
	private boolean deliveryReceipt;

	@JsonInclude()
	@Transient
	private boolean readReceipt;

	@JsonInclude()
	@Transient
	private boolean reminderRequested;

	@JsonInclude()
	@Transient
	private Date reminderDate;
	
	public Email() {
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Date getLastRetrievedDate() {
		return this.lastRetrievedDate;
	}

	public void setLastRetrievedDate(Date lastRetrievedDate) {
		this.lastRetrievedDate = lastRetrievedDate;
	}

	public String getEmailDetails() {
		return this.emailDetails;
	}

	public void setEmailDetails(String emailDetails) {
		this.emailDetails = emailDetails;
	}
	
	public Date getInstanceDate() {
		return instanceDate;
	}

	public void setInstanceDate(Date instanceDate) {
		this.instanceDate = instanceDate;
	}
	
	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public BigInteger getHistoryId() {
		return historyId;
	}

	public void setHistoryId(BigInteger bigInteger) {
		this.historyId = bigInteger;
	}
	
	public boolean isDeliveryReceipt() {
		return deliveryReceipt;
	}

	public void setDeliveryReceipt(boolean deliveryReceipt) {
		this.deliveryReceipt = deliveryReceipt;
	}

	public boolean isReadReceipt() {
		return readReceipt;
	}

	public void setReadReceipt(boolean readReceipt) {
		this.readReceipt = readReceipt;
	}

	public boolean isReminderRequested() {
		return reminderRequested;
	}

	public void setReminderRequested(boolean reminderRequested) {
		this.reminderRequested = reminderRequested;
	}

	public Date getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}
	
	public List<Contact> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<Contact> recipients) {
		this.recipients = recipients;
	}
	
}