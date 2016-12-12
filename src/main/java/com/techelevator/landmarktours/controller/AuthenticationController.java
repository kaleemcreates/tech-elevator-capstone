package com.techelevator.landmarktours.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
//	@RequestMapping(value="/login",method=RequestMethod.GET)   //Default Method
//	public  String  doLogin(@ModelAttribute CredentialsBean credentialsBean, HttpSession session)
//	{   
//	    String result="";
//	    if(credentialsBean!=null){
//	        if(authenticationDao.authenticate(credentialsBean)){
//	            String userType=authenticationDao.authorize(credentialsBean.getUserID());
//	            if(userType.equalsIgnoreCase("A")){
//
//	                CredentialsBean cBean= authenticationDao.changeLoginStatus(credentialsBean, 1);
//	                // add object to session
//	                session.setAttribute("session1",cBean);
//	                result= "admin";
//	                //map.put("username",credentialsBean.getProfileBean().getFirstName());
//	            }
//	            else{
//	                CredentialsBean cBean=authenticationDao.changeLoginStatus(credentialsBean, 1);
//	                session.setAttribute("session1",cBean);
//	                result= "customer";
//	            }
//	        }
//	        else{
//	            result="ERROR";
//	        }
//	    }
//
//	    return result;
//	}


	private boolean isValidRedirect(String destination) {
		return destination != null && destination.startsWith("http://localhost");
	}

	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public String logout(Map<String, Object> model, HttpSession session) {
		model.remove("currentUser");
		session.removeAttribute("currentUser");
		return "redirect:/";
	}
}
