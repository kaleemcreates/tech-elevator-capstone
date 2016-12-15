package com.techelevator.landmarktours.model;

import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCItineraryDAO implements ItineraryDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCItineraryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	public Itinerary getLatestItinerary(String userName) {
		String sqlGetCurrentItineraryId = "SELECT * "
										+ "FROM itinerary i "
										+ "INNER JOIN users_itinerary ui "
										+ "ON ui.itinerary_id=i.itinerary_id "
										+ "WHERE ui.user_name=? ORDER BY i.create_date DESC LIMIT 1";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCurrentItineraryId, userName);
		if (results.next()) {
			Itinerary itinerary = mapRowToItinerary(results);
			return itinerary;
		}
		return null;
	}
	
	@Override
	public int saveItineraryToItinerary(String itineraryName) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("itinerary_name", itineraryName);

        String sqlInsertItineraryName= "INSERT INTO itinerary (itinerary_name) VALUES (:itinerary_name)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        int nb = namedJdbcTemplate.update(sqlInsertItineraryName, parameters, keyHolder, new String[]{"itinerary_id"});
        
        return keyHolder.getKey().intValue();
	}

	
	@Override
	public List <ItineraryNameLandmark> getItineraryAndLandmarkById(int itineraryId) {
		
		String sqlgetItineraryAndLandmarkById= "SELECT DISTINCT i.itinerary_name, l.name "
												+ "FROM itinerary i "
												+ "INNER JOIN itinerary_landmarks il ON i.itinerary_id=il.itinerary_id "
												+ "INNER JOIN landmarks l ON l.landmark_id=il.landmark_id "
												+ "INNER JOIN users_itinerary ui ON ui.user_name=ui.user_name "
												+ "WHERE i.itinerary_id= ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetItineraryAndLandmarkById, itineraryId);
		if(results.next()) {
			return mapRowSetToItineraryNameAndLandmark(results);
		}
		
		return null;
	}
	
	@Override
	public void saveItineraryAndLandmark(int itineraryId, String landmarkId) {
		String sqlInsertItineraryandLandmark = "INSERT INTO itinerary_landmarks (itinerary_id, landmark_id ) VALUES (?,?)";
		jdbcTemplate.update(sqlInsertItineraryandLandmark, itineraryId, landmarkId);
		
	}
	
	@Override
	public void saveItineraryAndUser(String userName, int itineraryId ) {
	
		
		UsersItinerary userItinerary= new UsersItinerary();
		userItinerary.setItinerary_id(itineraryId);
		userItinerary.setUserName(userName);
		
		
		
		String sqlInsertItineraryandUser = "INSERT INTO users_itinerary (user_name, itinerary_id) VALUES (?,?)";
		jdbcTemplate.update(sqlInsertItineraryandUser,  userName, itineraryId);
		
	}
	
	
	private Itinerary mapRowToItinerary(SqlRowSet results) {
		Itinerary itinerary = new Itinerary();
		itinerary.setItineraryId(results.getInt("itinerary_id"));
		itinerary.setItineraryName(results.getString("itinerary_name"));
		itinerary.setCreateDate(results.getTimestamp("create_date").toLocalDateTime());
		
		
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
