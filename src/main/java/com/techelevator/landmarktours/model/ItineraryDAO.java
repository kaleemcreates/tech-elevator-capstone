package com.techelevator.landmarktours.model;

import java.util.List;

public interface ItineraryDAO {
	
	public List<Itinerary> getItinerary();
	public int getItineraryId();
	public void saveItineraryToItinerary(String itineraryName);
	public void saveItineraryAndLandmark(int itineraryId, String landmarkId);
	public void saveItineraryAndUser(String userName, int itineraryId );
	public List<ItineraryNameLandmark> getItineraryAndLandmarkByUserName(String userName);
}
