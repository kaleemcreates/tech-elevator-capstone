package com.techelevator.landmarktours.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCItineraryLandmarksDAO implements ItineraryLandmarksDA0   {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCItineraryLandmarksDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List <ItineraryLandmarks> getItineraryByIdAndLandmarks(int itineraryId) {
		
		String sqlSelectLandmarksByItinerary = "SELECT * FROM itinerary_landmarks WHERE itinerary_id = ?";
		
		SqlRowSet results =jdbcTemplate.queryForRowSet(sqlSelectLandmarksByItinerary, itineraryId);
		return mapRowSetToItineraryLandmarks(results);
		
	}

	private List<ItineraryLandmarks> mapRowSetToItineraryLandmarks(SqlRowSet results) {
		ArrayList<ItineraryLandmarks> itineraryLandmarkList = new ArrayList<>();
		while(results.next()) {
			itineraryLandmarkList.add(mapRowToItineraryLandmarks(results));
		}
		return itineraryLandmarkList;
	}
	
	
	private ItineraryLandmarks mapRowToItineraryLandmarks(SqlRowSet results) {
		ItineraryLandmarks itineraryLandmark = new ItineraryLandmarks();
		
		itineraryLandmark.setItineraryId(results.getInt("itinerary_id"));
		itineraryLandmark.setLandmarkId(results.getString("landmark_id"));
		
		return  itineraryLandmark;		

	}


}
