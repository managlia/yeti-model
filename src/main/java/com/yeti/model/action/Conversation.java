package com.yeti.model.action;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the conversation database table.
 * 
 */
@Entity
@Table(name="conversation")
@NamedQuery(name="Conversation.findAll", query="SELECT c FROM Conversation c")
public class Conversation extends Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="conversation_duration")
	private String duration;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="conversation_start_datetime")
	private Date conversationStartTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="conversation_end_datetime")
	private Date conversationEndTime;

	public Conversation() {
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getConversationStartTime() {
		return conversationStartTime;
	}

	public void setConversationStartTime(Date conversationStartTime) {
		this.conversationStartTime = conversationStartTime;
	}

	public Date getConversationEndTime() {
		return conversationEndTime;
	}

	public void setConversationEndTime(Date conversationEndTime) {
		this.conversationEndTime = conversationEndTime;
	}
}