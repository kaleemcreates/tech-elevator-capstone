package com.techelevator.landmarktours.model;

import java.time.LocalDateTime;

public class Itinerary {
	
	private int itineraryId;
	private String itineraryName;
	private LocalDateTime createDate;

	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public int getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(int itineraryId) {
		this.itineraryId = itineraryId;
	}
	public String getItineraryName() {
		return itineraryName;
	}
	public void setItineraryName(String itineraryName) {
		this.itineraryName = itineraryName;
	}

}
