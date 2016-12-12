package com.techelevator.landmarktours.model;

public interface UserDAO {

	public void saveUser(User user, String password);

	public boolean searchForUsernameAndPassword(String userName, String password);

	public User getUserWithUserName(String userName);

	public void updatePassword(String userName, String password);

}
