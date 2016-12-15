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
	
	@Override
	public void saveItineraryToItinerary(String itineraryName) {
		
		String sqlInsertItineraryName= "INSERT INTO itinerary (itinerary_name) VALUES (?)";
		jdbcTemplate.update(sqlInsertItineraryName, itineraryName);

	}
	
	@Override
	public int getItineraryId() {
		int id=0;
		String sqlGetCurrentItineraryId= "SELECT currval(pg_get_serial_sequence('itinerary','itinerary_id'))";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCurrentItineraryId);
		if(results.next()) {
				 id= results.getInt(1);
				 
		}
		return id;
	}
	
	@Override
	public List <ItineraryNameLandmark> getItineraryAndLandmarkById(int itineraryId) {
		
		String sqlgetItineraryAndLandmarkById= "SELECT i.itinerary_name, l.name "
													+ "FROM itinerary i "
													+ "INNER JOIN itinerary_landmarks il ON i.itinerary_id=il.itinerary_id "
													+ "INNER JOIN landmarks l ON l.landmark_id=il.landmark_id "
													+ "WHERE i.itinerary_id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetItineraryAndLandmarkById, itineraryId);
		if(results.next()) {
			
		}
		
		return mapRowSetToItineraryNameAndLandmark(results);
	}
	
	@Override
	public void saveItineraryAndLandmark(int itineraryId, String landmarkId) {
		String sqlInsertItineraryandLandmark = "INSERT INTO itinerary_landmarks (itinerary_id, landmark_id ) VALUES (?,?)";
		jdbcTemplate.update(sqlInsertItineraryandLandmark, itineraryId, landmarkId);
		
	}
	
	@Override
	public void saveItineraryAndUser(String userName, int itineraryId ) {
		String sqlInsertItineraryandUser = "INSERT INTO users_itinerary (user_name, itinerary_id ) VALUES (?,?)";
		jdbcTemplate.update(sqlInsertItineraryandUser,  userName, itineraryId );
		
	}
	
	
	private Itinerary mapRowToItinerary(SqlRowSet results) {
		Itinerary itinerary = new Itinerary();
		itinerary.setItineraryId(results.getInt("itinerary_id"));
		itinerary.setItineraryName(results.getString("itinerary_name"));
		
		return itinerary;
	}
	private List <ItineraryNameLandmark> mapRowSetToItineraryNameAndLandmark(SqlRowSet results) {
		List <ItineraryNameLandmark> itineraryNameLandmark = new ArrayList<ItineraryNameLandmark>();
		while(results.next()) {
			itineraryNameLandmark.add(mapRowToItineraryNameAndLandmark(results));
		}
		return itineraryNameLandmark;
	}
	
	private ItineraryNameLandmark mapRowToItineraryNameAndLandmark(SqlRowSet results) {
		ItineraryNameLandmark itineraryNameLandmark = new ItineraryNameLandmark();
		
		itineraryNameLandmark.setItineraryName(results.getString("itinerary_name"));
		itineraryNameLandmark.setlandmarkName(results.getString("name"));
		
		return itineraryNameLandmark;
	}




}
