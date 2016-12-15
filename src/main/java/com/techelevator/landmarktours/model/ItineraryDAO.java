package com.techelevator.landmarktours.model;

import java.util.List;

public interface ItineraryDAO {
	
	public Itinerary getLatestItinerary(String userName);
	public int saveItineraryToItinerary(String itineraryName);
	public void saveItineraryAndLandmark(int itineraryId, String landmarkId);
	public void saveItineraryAndUser(String userName, int itineraryId );
	
	public List<ItineraryNameLandmark> getItineraryAndLandmarkById(int itineraryId);
	
}
