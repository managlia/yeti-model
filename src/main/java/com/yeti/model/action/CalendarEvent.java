package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Action/Reminder database table.
 * 
 */
@Entity
@Table(name="calendar_event")
@NamedQuery(name="Reminder.findAll", query="SELECT c FROM CalendarEvent c")
public class CalendarEvent extends Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="calendar_event_external_id")
	private String externalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="calendar_event_last_retrieved_date")
	private Date lastRetrievedDate;

	@Lob
	@Column(name="calendar_event_last_retrieved_value")
	private String lastRetrievedValue;

	public CalendarEvent() {
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

	public String getLastRetrievedValue() {
		return this.lastRetrievedValue;
	}

	public void setLastRetrievedValue(String lastRetrievedValue) {
		this.lastRetrievedValue = lastRetrievedValue;
	}
	
}