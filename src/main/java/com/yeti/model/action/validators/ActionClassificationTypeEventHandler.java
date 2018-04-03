package com.yeti.model.action.validators;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.yeti.model.action.ActionClassificationType;

@Component
@RepositoryEventHandler 
public class ActionClassificationTypeEventHandler {

	@HandleBeforeSave(ActionClassificationType.class)
	public void handleActionClassificationTypeSave(ActionClassificationType p) {
		System.out.println("@HandleBeforeSave validation when using REST Data");
	}

	@HandleBeforeCreate(ActionClassificationType.class)
	public void handleActionClassificationTypeCreate(ActionClassificationType p) {
		System.out.println("@HandleBeforeCreate validation when using REST Data");
	}
	
	
}