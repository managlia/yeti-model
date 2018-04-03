package com.yeti.model.action.validators;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.yeti.model.action.ActionClassificationType;

public class ActionClassificationTypeListener {

	@PrePersist
	public void userPrePersist(ActionClassificationType ob) {
		System.out.println("Listening User Pre Persist : " + ob.getName());
	}

	@PostPersist
	public void userPostPersist(ActionClassificationType ob) {
		System.out.println("Listening User Post Persist : " + ob.getName());
	}
	
	@PostLoad
	public void userPostLoad(ActionClassificationType ob) {
		System.out.println("Listening User Post Load : " + ob.getName());
	}	
	
	@PreUpdate
	public void userPreUpdate(ActionClassificationType ob) {
		System.out.println("Listening User Pre Update : " + ob.getName());
	}
	
	@PostUpdate
	public void userPostUpdate(ActionClassificationType ob) {
		System.out.println("Listening User Post Update : " + ob.getName());
	}
	
	@PreRemove
	public void userPreRemove(ActionClassificationType ob) {
		System.out.println("Listening User Pre Remove : " + ob.getName());
	}
	
	@PostRemove
	public void userPostRemove(ActionClassificationType ob) {
		System.out.println("Listening User Post Remove : " + ob.getName());
	}
} 