package com.techelevator.landmarktours.model;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface ItineraryLandmarksDAO {
	
	public List <ItineraryLandmarks> getItineraryByIdAndLandmarks(int itineraryId);
	
}
