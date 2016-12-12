package com.techelevator.landmarktours.model;

import java.sql.Statement;
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
	
	public Itinerary saveItineraryAndLandmark(Itinerary itineraryName, Landmarks landmarkId) {
		Itinerary itinerary = null;
		
		String sqlInsertItineraryName= "INSERT INTO itinerary (itinerary_name) VALUES (?)";
		jdbcTemplate.update(sqlInsertItineraryName, itineraryName);
		String sqlGetCurrentItineraryId= "SELECT currval(pg_get_serial_sequence('itinerary','itinerary_id'))";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsertItineraryName, itineraryName, sqlGetCurrentItineraryId);
		if(results.next()) {
			itinerary=mapRowToItinerary(results);
		}
		
		String sqlInsertItineraryandLandmark = "INSERT INTO itinerary_landmark(itinerary_id, landmark_id ) VALUES (?,?)";
		
		jdbcTemplate.update(sqlInsertItineraryandLandmark, itinerary.getitineraryId(), landmarkId);
			
		return itinerary;
	}
	
	public List <Itinerary> getItineraryByIdAndLandmarks(Itinerary itineraryId) {
		Itinerary itinerary=null;
		List <Itinerary> list= new ArrayList<Itinerary>();
		String sqlSelectItineraryByName = "SELECT * "
											+ "FROM itinerary_landmark "
											+ "WHERE itinerary_id = ?";
		
		SqlRowSet results =jdbcTemplate.queryForRowSet(sqlSelectItineraryByName, itineraryId);
		if(results.next()) {
			itinerary = mapRowToItinerary(results);
			list.add(itinerary);
		}
		return list;
	}
	
	
	private Itinerary mapRowToItinerary(SqlRowSet results) {
		Itinerary itinerary = new Itinerary();
		itinerary.setItineraryId("itinerary_id");
		itinerary.setItineraryName("itinerary_name");
		
		return itinerary;
	}

	@Override
	public Itinerary saveItinerary(Itinerary itineraryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Itinerary getItineraryByName(String itinerary) {
		// TODO Auto-generated method stub
		return null;
	}


}
