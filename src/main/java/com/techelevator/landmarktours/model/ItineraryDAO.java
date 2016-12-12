package com.techelevator.landmarktours.model;

import java.util.List;

public interface ItineraryDAO {
	
	public List<Itinerary> getItinerary();
	public Itinerary saveItinerary(Itinerary itineraryName);
	public Itinerary getItineraryByName(String itinerary);

}
