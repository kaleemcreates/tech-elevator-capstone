package com.techelevator.landmarktours.model;

public interface UserDAO {

	public void saveUser(String userName, String password, String role);

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

}
