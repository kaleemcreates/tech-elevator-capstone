package com.techelevator.landmarktours.model;

import java.util.List;

public interface LandmarkSuggestionsDAO {
	public LandmarkSuggestions getLandmarkSuggestions();
	public void save(LandmarkSuggestions suggestion);

	public void removeSuggestion(int suggestionId);

}
