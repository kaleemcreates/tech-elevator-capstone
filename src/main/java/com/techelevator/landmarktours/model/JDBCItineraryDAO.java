package com.techelevator.landmarktours.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCItineraryDAO implements ItineraryDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
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
	public void saveItinerary(Itinerary itinerary) {
		
		jdbcTemplate.update("INSERT INTO itinerary(itinerary_name) VALUES (?)",
				itinerary.getItineraryName());
		
	}
	
	public Itinerary getItineraryByName(String itineraryName) {
		Itinerary itinerary=null;
		String sqlSelectItineraryByName = "SELECT * "
											+ "FROM itinerary "
											+ "WHERE itinerary_name = ?";
		
		SqlRowSet results =jdbcTemplate.queryForRowSet(sqlSelectItineraryByName, itineraryName);
		if(results.next()) {
			itinerary = mapRowToItinerary(results);
		}
		
		
		return itinerary;
	}
	
	
	private Itinerary mapRowToItinerary(SqlRowSet results) {
		Itinerary itinerary = new Itinerary();
		itinerary.setItineraryId("itinerary_id");
		itinerary.setItineraryName("itinerary_name");
		
		return itinerary;
	}


}
