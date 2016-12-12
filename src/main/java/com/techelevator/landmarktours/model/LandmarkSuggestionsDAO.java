package com.techelevator.landmarktours.model;

import java.util.List;

public interface LandmarkSuggestionsDAO {
	public List<LandmarkSuggestions> getLandmarkSuggestions();
	public void save(LandmarkSuggestions suggestion);

}
