package com.techelevator.landmarktours.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCLandmarkSuggestionsDAO implements LandmarkSuggestionsDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCLandmarkSuggestionsDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LandmarkSuggestions> getLandmarkSuggestions() {
		List<LandmarkSuggestions> landmarkSuggestions = new ArrayList<>();
		String sqlSelectLandmarkSuggestions = "SELECT * "
											+ "FROM landmark_suggestions";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectLandmarkSuggestions);
		while(results.next()) {
			LandmarkSuggestions landmarkSuggestion = new LandmarkSuggestions();
			landmarkSuggestion.setSuggestionId(results.getInt("suggestion_id"));
			landmarkSuggestion.setName(results.getString("name"));
			landmarkSuggestion.setType(results.getString("type"));
			landmarkSuggestion.setZip(results.getString("zip"));
			landmarkSuggestion.setDescription(results.getString("description"));
			landmarkSuggestion.setDateRequested(results.getTimestamp("date_requested").toLocalDateTime());
			landmarkSuggestions.add(landmarkSuggestion);
		}
		
		return landmarkSuggestions;
	}

	@Override
	public void save(LandmarkSuggestions suggestion) {

		int suggestionId = getNextId();
		String sqlInsertLandmarkSuggestion = "INSERT INTO landmark_suggestions(suggestion_id, name, type, zip, description, date_requested) "
											+ "VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertLandmarkSuggestion, suggestionId, suggestion.getName(), suggestion.getType(), suggestion.getZip(), suggestion.getDescription(), suggestion.getDateRequested());
		suggestion.getSuggestionId(suggestionId);
		
	}
	
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL ('landmark_suggestions_suggestion_id_seq')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id;
		if(results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next landmark suggestion id from sequence");
		} 
		return id;


		// TODO Auto-generated method stub
		
	}

}
