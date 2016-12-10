package com.techelevator.landmarktours.model;

import java.util.List;

public interface ItineraryDAO {
	
	public List<Itinerary> getItinerary();
	public void saveItinerary(String itineraryName);
	public Itinerary getItineraryByName(String itineraryName);

}
