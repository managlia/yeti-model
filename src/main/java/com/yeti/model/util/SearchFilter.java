package com.yeti.model.util;

import java.util.Optional;

public class SearchFilter {

	private Optional<String> name;
	private Optional<String> description;
	
	public Optional<String> getName() {
		return name;
	}
	public void setName(Optional<String> name) {
		this.name = name;
	}
	public Optional<String> getDescription() {
		return description;
	}
	public void setDescription(Optional<String> description) {
		this.description = description;
	}

}
