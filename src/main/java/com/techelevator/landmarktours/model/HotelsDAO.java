package com.techelevator.landmarktours.model;

import java.util.List;

public interface HotelsDAO {

	public void getHotelById(String locationId);

	public List<Hotels> getHotels();

	
}
