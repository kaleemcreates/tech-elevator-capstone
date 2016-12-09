package com.techelevator.landmarktours.model;

import java.util.List;

public interface LandmarksDAO {

	public List<Landmarks> getLandmarks();
	public Landmarks getLandmarksById(String landmarkId);

	public void saveLandmarks(Landmarks landmark);
	public Landmarks getLandmarksByType(String type);

	
	public Landmarks searchLandMarksByRadius(String landmarkId);
	 



}
