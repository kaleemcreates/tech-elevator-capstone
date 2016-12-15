package com.techelevator.landmarktours.controller;

import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.landmarktours.model.Landmarks;
import com.techelevator.landmarktours.model.User;
import com.techelevator.landmarktours.model.UserDAO;

@Controller
@SessionAttributes("currentUser")
public class AuthenticationController {

	private UserDAO userDAO;

	@Autowired
	public AuthenticationController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm() {
		return "login";
	}
//	@RequestMapping(path="/users/adminUser", method=RequestMethod.GET)
//	public String displayNewUserFormAdmin(HttpServletRequest request) {
//		
//		
//		
//		return "adminUser";
//	}
//	@RequestMapping(path="/users/{userName}/adminUser", method=RequestMethod.GET)
//	public String displayUserInfoChangeAdmin(Map<String, Object> model, @PathVariable String userName) {
//		model.put("userName", userName);
//		return "adminUser";
//	}
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(Map<String, Object> model, 
						@RequestParam String userName, 
						@RequestParam String password,
						@RequestParam(required=false) String destination,
						HttpSession session) {
		
		if(userDAO.searchForUsernameAndPassword(userName, password)) {
			session.invalidate();
			User user = userDAO.getUserWithUserName(userName);
			model.put("currentUser", user);
			if(isValidRedirect(destination)) {
				return "redirect:"+destination;
			} else {
				return "redirect:/users/"+userName;
			}
		} else {
			return "redirect:/login";
		}
	}



	private boolean isValidRedirect(String destination) {
		return destination != null && destination.startsWith("http://localhost");
	}

//	@RequestMapping(path="/logout", method=RequestMethod.POST)
//	public String logout(Map<String, Object> model, HttpSession session) {
//	//public String logout(Map<String, Object> model, HttpSession session, Object userName) {
//		//User user = userDAO.getUserWithUserName(userName);
//		//model.remove("currentUser", userName);
//		model.remove("currentUser");
//		session.removeAttribute("currentUser");
//		return "redirect:/";
//	}
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public String logout(Map<String, Object> model, HttpSession session) {
	//public String logout(Map<String, Object> model, HttpSession session, Object userName) {
		//User user = userDAO.getUserWithUserName(userName);
		//model.remove("currentUser", userName);
		model.remove("currentUser");
		session.removeAttribute("currentUser");
		return "redirect:/login";
	}
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
////	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////	    if (auth != null){    
////	        new SecurityContextLogoutHandler().logout(request, response, auth);
////	    }
//	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//	}
} 
