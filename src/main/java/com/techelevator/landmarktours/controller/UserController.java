package com.techelevator.landmarktours.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.landmarktours.model.Landmarks;
import com.techelevator.landmarktours.model.LandmarksDAO;
import com.techelevator.landmarktours.model.UserDAO;

@Controller
public class UserController {

	private UserDAO userDAO;
	private LandmarksDAO landmarksDAO;

	@Autowired
	public UserController(UserDAO userDAO, LandmarksDAO landmarksDAO) {
		this.userDAO = userDAO;
		this.landmarksDAO = landmarksDAO;
	}

	@RequestMapping(path="/users/new", method=RequestMethod.GET)
	public String displayNewUserForm(HttpServletRequest request) {
		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
		request.setAttribute("landmarkList", landmarkList);
		
		return "newUser";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@RequestParam String userName, @RequestParam String password, @RequestParam String role) {
		userDAO.saveUser(userName, password, role);
		return "redirect:/login";
	}
	
	@RequestMapping(path="/users/{userName}", method=RequestMethod.GET)
	public String displayDashboard(Map<String, Object> model, 
									HttpServletRequest request,
									@PathVariable String userName) {
	//	model.put("conversations", landmarksDAO.getSavedList(userName));
	
		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
		request.setAttribute("landmarkList", landmarkList);
		
		return "userDashboard";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.GET)
	public String displayChangePasswordForm(Map<String, Object> model, @PathVariable String userName) {
		model.put("userName", userName);
		return "changePassword";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.POST)
	public String changePassword(@PathVariable String userName, @RequestParam String password) {
		userDAO.updatePassword(userName, password);
		return "userDashboard";
	}
	
//	@RequestMapping(path="/adminLanding", method=RequestMethod.GET)
//	public String displayNewAdminForm(HttpServletRequest request) {
//		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
//		request.setAttribute("landmarkList", landmarkList);
//		
//		return "/adminLanding";
//	}
//	
//	@RequestMapping(path="/adminLanding", method=RequestMethod.POST)
//	public String createAdmin(@RequestParam String userName, @RequestParam String password, @RequestParam String role) {
//		userDAO.saveUser(userName, password, role);
//		return "/adminLanding";
//	}
	

}
