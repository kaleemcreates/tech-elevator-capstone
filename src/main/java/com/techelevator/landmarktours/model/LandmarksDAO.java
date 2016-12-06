package com.techelevator.landmarktours.model;

import java.util.List;

public interface LandmarksDAO {

	public List<Landmarks> getLandmarks(int limit);

	public void saveLandmarks(Landmarks landmark);


}
