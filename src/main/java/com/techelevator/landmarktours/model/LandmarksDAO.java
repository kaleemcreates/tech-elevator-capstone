package com.techelevator.landmarktours.model;

import java.util.List;

public interface LandmarksDAO {

	public List<Landmarks> getLandmarks(int limit);
	public Landmarks getLandmarksById(String landmarkId);

	public void saveLandmarks(Landmarks landmark);
	Landmarks getLandmarksByType(String type);
	
	public Landmarks searchLandMarksByRadius(String landmarkId); 


}
