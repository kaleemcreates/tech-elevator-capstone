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
			landmarkSuggestion.setName(results.getString("name"));
			landmarkSuggestion.setType(results.getString("type"));
			landmarkSuggestion.setZip(results.getString("zip"));
			landmarkSuggestion.setDescription(results.getString("description"));
			landmarkSuggestions.add(landmarkSuggestion);
		}
		
		return landmarkSuggestions;
	}

}
