package com.techelevator.landmarktours.model;

import java.util.List;

public interface LandmarksDAO {

	public List<Landmarks> getLandmarks(int limit);
	public Landmarks getLandmarksById(String landmarkId);

	public void saveLandmarks(Landmarks landmark);
<<<<<<< HEAD
	public Landmarks getLandmarksByType(String type);
=======
	Landmarks getLandmarksByType(String type);
	
	public Landmarks searchLandMarksByRadius(String landmarkId); 
>>>>>>> 94d768ad954a3e73e721b4f9291335323f8f49dd


}
