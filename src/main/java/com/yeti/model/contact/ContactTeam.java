package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="contact_team")
@NamedQuery(name="ContactTeam.findAll", query="SELECT c FROM ContactTeam c")
public class ContactTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_team_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer contactTeamId;

	@Column(name="contact_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer contactId;	
	
	@Column(name="team_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer teamId;

	public Integer getContactTeamId() {
		return contactTeamId;
	}

	public void setContactTeamId(Integer contactTeamId) {
		this.contactTeamId = contactTeamId;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}	
	
	
}