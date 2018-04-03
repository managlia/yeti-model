package com.yeti.model.util;

import java.util.List;
import java.util.Map;

public class Batch {

	private String mergeType; //ie. rename, merge, delete, insert
	private List<Object> newObjects; //entity objects to add or remove 
	private Map<String,String> oldValues; //what to change
	private Map<String,String> newValues; //what to change to

	public String getMergeType() {
		return mergeType;
	}
	public void setMergeType(String mergeType) {
		this.mergeType = mergeType;
	}
	public List<Object> getNewObjects() {
		return newObjects;
	}
	public void setNewObjects(List<Object> newObjects) {
		this.newObjects = newObjects;
	}
	public Map<String, String> getOldValues() {
		return oldValues;
	}
	public void setOldValues(Map<String, String> oldValues) {
		this.oldValues = oldValues;
	}
	public Map<String, String> getNewValues() {
		return newValues;
	}
	public void setNewValues(Map<String, String> newValues) {
		this.newValues = newValues;
	}
	
}
