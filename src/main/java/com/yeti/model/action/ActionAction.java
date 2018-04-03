package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;


/**
 * The persistent class for the action_action database table.
 * 
 */
@Entity
@Table(name="action_action")
@NamedQuery(name="ActionAction.findAll", query="SELECT a FROM Action a")
public class ActionAction extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_action_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer actionActionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_action_linkage_date")
	private Date linkageDate;

	//bi-directional many-to-one association to Action
	@Column(name="child_action_id")
	private Integer childActionId;
	
	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="parent_action_id")
	@JsonBackReference(value="action-action")
	private Action parentAction;

	public ActionAction() {
	}

	public Integer getActionActionId() {
		return this.actionActionId;
	}

	public void setActionActionId(Integer actionActionId) {
		this.actionActionId = actionActionId;
	}

	public Date getLinkageDate() {
		return this.linkageDate;
	}

	public void setLinkageDate(Date linkageDate) {
		this.linkageDate = linkageDate;
	}

	public Integer getChildActionId() {
		return this.childActionId;
	}

	public void setChildActionId(Integer childActionId) {
		this.childActionId = childActionId;
	}

	public Action getParentAction() {
		return this.parentAction;
	}

	public void setParentAction(Action parentAction) {
		this.parentAction = parentAction;
	}

}