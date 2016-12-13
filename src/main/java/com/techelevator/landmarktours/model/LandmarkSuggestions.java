package com.techelevator.landmarktours.model;

import java.time.LocalDateTime;

public class LandmarkSuggestions {
	
	private int suggestionId;
	private String name;
	private String type;
	private String zip;
	private String description;
	private LocalDateTime dateRequested;
	
	public LocalDateTime getDateRequested() {
		return dateRequested;
	}
	public void setDateRequested(LocalDateTime dateRequested) {
		this.dateRequested = dateRequested;
	}
	public int getSuggestionId(int suggestionId) {
		return suggestionId;
	}
	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
