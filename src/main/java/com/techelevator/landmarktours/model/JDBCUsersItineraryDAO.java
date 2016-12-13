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
public class JDBCUsersItineraryDAO implements UsersItineraryDAO   {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCUsersItineraryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public List <UsersItinerary> getItineraryByIdAndLandmarks(int itineraryId) {
		
		String sqlSelectLandmarksByItinerary = "SELECT * FROM itinerary_landmarks WHERE itinerary_id = ?";
		
		SqlRowSet results =jdbcTemplate.queryForRowSet(sqlSelectLandmarksByItinerary, itineraryId);
		return mapRowSetToUsersItinerary(results);
		
	}

	private List<UsersItinerary> mapRowSetToUsersItinerary(SqlRowSet results) {
		ArrayList<UsersItinerary> usersItineraryList = new ArrayList<>();
		while(results.next()) {
			usersItineraryList.add(mapRowToUsersItinerary(results));
		}
		return usersItineraryList;
	}
	
	
	private UsersItinerary mapRowToUsersItinerary(SqlRowSet results) {
		UsersItinerary usersItinerary= new UsersItinerary();
		
		usersItinerary.setUserName(results.getString("user_name"));
		usersItinerary.setItinerary_id(results.getInt("itinerary_id"));
		
		return  usersItinerary;		

	}


	@Override
	public void saveUserAndItinerary(String userName, int itineraryId) {
		// TODO Auto-generated method stub
		
	}

	


}
