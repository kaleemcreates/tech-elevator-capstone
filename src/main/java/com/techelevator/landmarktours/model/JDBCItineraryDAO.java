package com.techelevator.landmarktours.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCItineraryDAO implements ItineraryDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCItineraryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Itinerary> getItinerary() {
		List <Itinerary> itineraries = new ArrayList<Itinerary>();
		String sqlGetAllItineraries= "SELECT * "
									+ "FROM itinerary";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllItineraries);
		while (results.next()) {
			Itinerary itinerary = mapRowToItinerary(results);
			itineraries.add(itinerary);
		}
		return itineraries;
	}
	public void saveItinerary(String itineraryName) {
		
		
	}
	
	public Itinerary getItineraryByName(String itineraryName) {
		
		
		
		return null;
	}
	
	
	private Itinerary mapRowToItinerary(SqlRowSet results) {
		Itinerary itinerary = new Itinerary();
		itinerary.setItineraryId("itinerary_id");
		itinerary.setItineraryName("itinerary_name");
		
		return itinerary;
	}

}
