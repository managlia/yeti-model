package com.yetix.model.send;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="send_queue")
@NamedQuery(name="SendQueue.findAll", query="SELECT s FROM SendQueue s")
public class SendQueue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="send_queue_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer sendQueueId;
	
	@Column(name="send_queue_creator_id")
	private String sendQueueCreatorId;

	@Column(name="send_queue_creator_external_id")
	private String sendQueueCreatorExternalId;
	
	// send_pending, sent, canceled, cancellation_complete
	@Column(name="send_queue_item_type")
	private String sendQueueItemType;
	
	@Column(name="send_queue_payload")
	private File sendQueuePayload;

	@Column(name="linked_to_entity_type")
	private String linkedToEntityType;
	
	@Column(name="linked_to_entity_id")
	private String linkedToEntityId;
	
    @Column(
        name = "recipients", 
        columnDefinition = "string[]"
    )	
	private String[] recipients;

	@CreationTimestamp
	@Column(name="send_queue_create_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date sendQueueCreateDate;
	
	@Column(name="send_queue_transmission_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date sendQueueTransmissionDate;
	
	@Column(name="send_queue_cancel_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date sendQueueCancelDate;
	
 	@Column(name="send_queue_cancel_transmission_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
	private Date sendQueueCancelTransmissionDate;

	public Integer getSendQueueId() {
		return sendQueueId;
	}

	public void setSendQueueId(Integer sendQueueId) {
		this.sendQueueId = sendQueueId;
	}

	public String getSendQueueCreatorId() {
		return sendQueueCreatorId;
	}

	public void setSendQueueCreatorId(String sendQueueCreatorId) {
		this.sendQueueCreatorId = sendQueueCreatorId;
	}

	public String getSendQueueCreatorExternalId() {
		return sendQueueCreatorExternalId;
	}

	public void setSendQueueCreatorExternalId(String sendQueueCreatorExternalId) {
		this.sendQueueCreatorExternalId = sendQueueCreatorExternalId;
	}

	public String getSendQueueItemType() {
		return sendQueueItemType;
	}

	public void setSendQueueItemType(String sendQueueItemType) {
		this.sendQueueItemType = sendQueueItemType;
	}

	public File getSendQueuePayload() {
		return sendQueuePayload;
	}

	public void setSendQueuePayload(File sendQueuePayload) {
		this.sendQueuePayload = sendQueuePayload;
	}

	public String getLinkedToEntityType() {
		return linkedToEntityType;
	}

	public void setLinkedToEntityType(String linkedToEntityType) {
		this.linkedToEntityType = linkedToEntityType;
	}

	public String getLinkedToEntityId() {
		return linkedToEntityId;
	}

	public void setLinkedToEntityId(String linkedToEntityId) {
		this.linkedToEntityId = linkedToEntityId;
	}

	public String[] getRecipients() {
		return recipients;
	}

	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}

	public Date getSendQueueCreateDate() {
		return sendQueueCreateDate;
	}

	public void setSendQueueCreateDate(Date sendQueueCreateDate) {
		this.sendQueueCreateDate = sendQueueCreateDate;
	}

	public Date getSendQueueTransmissionDate() {
		return sendQueueTransmissionDate;
	}

	public void setSendQueueTransmissionDate(Date sendQueueTransmissionDate) {
		this.sendQueueTransmissionDate = sendQueueTransmissionDate;
	}

	public Date getSendQueueCancelDate() {
		return sendQueueCancelDate;
	}

	public void setSendQueueCancelDate(Date sendQueueCancelDate) {
		this.sendQueueCancelDate = sendQueueCancelDate;
	}

	public Date getSendQueueCancelTransmissionDate() {
		return sendQueueCancelTransmissionDate;
	}

	public void setSendQueueCancelTransmissionDate(Date sendQueueCancelTransmissionDate) {
		this.sendQueueCancelTransmissionDate = sendQueueCancelTransmissionDate;
	}
}












