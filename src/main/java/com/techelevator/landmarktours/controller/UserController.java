package com.techelevator.landmarktours.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.techelevator.landmarktours.model.Hotels;
import com.techelevator.landmarktours.model.HotelsDAO;
import com.techelevator.landmarktours.model.Itinerary;
import com.techelevator.landmarktours.model.ItineraryDAO;
import com.techelevator.landmarktours.model.ItineraryLandmarks;
import com.techelevator.landmarktours.model.ItineraryLandmarksDAO;
import com.techelevator.landmarktours.model.ItineraryNameLandmark;
import com.techelevator.landmarktours.model.LandmarkSuggestions;
import com.techelevator.landmarktours.model.LandmarkSuggestionsDAO;
import com.techelevator.landmarktours.model.Landmarks;
import com.techelevator.landmarktours.model.LandmarksDAO;
import com.techelevator.landmarktours.model.User;
import com.techelevator.landmarktours.model.UserDAO;

@Controller
@SessionAttributes({"landmarkListByItineraryId"})
public class UserController {

	private UserDAO userDAO;
	private LandmarksDAO landmarksDAO;
	private ItineraryLandmarksDAO itineraryLandmarksDAO;
	private ItineraryDAO itineraryDAO;
	private HotelsDAO hotelsDAO;
	private LandmarkSuggestionsDAO landmarkSuggestionsDAO;

	@Autowired
	public UserController(UserDAO userDAO, LandmarksDAO landmarksDAO,
						ItineraryLandmarksDAO itineraryLandmarksDAO,
						HotelsDAO hotelsDAO, ItineraryDAO itineraryDAO,
						LandmarkSuggestionsDAO landmarkSuggestionsDAO) {
		this.userDAO = userDAO;
		this.landmarksDAO = landmarksDAO;
		this.itineraryLandmarksDAO = itineraryLandmarksDAO;
		this.hotelsDAO = hotelsDAO;
		this.itineraryDAO= itineraryDAO;
		this.landmarkSuggestionsDAO= landmarkSuggestionsDAO;
	}

	@RequestMapping(path="/users/new", method=RequestMethod.GET)
	public String displayNewUserForm(HttpServletRequest request) {
		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
		request.setAttribute("landmarkList", landmarkList);
		
		return "newUser";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@RequestParam String userName, @RequestParam String password, @RequestParam String role) {
		userDAO.saveUser(new User(userName, role), password);
		return "redirect:/login";
	}
	
	@RequestMapping(path="/users/{userName}", method=RequestMethod.GET)
	public String displayDashboard(Map<String, Object> model, 
									HttpServletRequest request,
									@PathVariable String userName) {
		model.put("landmarks", landmarksDAO.getLandmarks());
		List <Hotels> hotelList= hotelsDAO.getHotels();
		request.setAttribute("hotelList", hotelList);
		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
		request.setAttribute("landmarkList", landmarkList);
		
		
		return "userDashboard";
	}
	
	@RequestMapping(path="/users/{userName}", method=RequestMethod.POST)
	public String postSavedItinerary(@RequestParam String itineraryName,
									@RequestParam String [] landmarkId,
									ModelMap model, @PathVariable String userName) {
		
		
		itineraryDAO.saveItineraryToItinerary(itineraryName);
		
		int itineraryId=itineraryDAO.getItineraryId();
		


		itineraryDAO.saveItineraryAndUser(userName, itineraryId);
		
		for (int i=0; i < landmarkId.length; i++) {
			String landmarkid =landmarkId[i];
			itineraryDAO.saveItineraryAndLandmark(itineraryId, landmarkid);
			
		}
			
		
		model.put("itineraryName", itineraryName.toUpperCase());
		model.put("itineraryId", itineraryId);
		
		List<ItineraryLandmarks> landmarkList= itineraryLandmarksDAO.getItineraryByIdAndLandmarks(itineraryId);
		model.put("landmarkListByItineraryId", landmarkList);
		
		
		return "redirect: {userName}/savedItineraryView";
	}
	
	@RequestMapping(path="/users/{userName}/savedItineraryView", method=RequestMethod.GET)
	public String showSavedItineraryView(Map<String, Object> model, HttpServletRequest request, @PathVariable String userName ) {
		
		model.put("userName", userName);
		
		return "savedItineraryView";
	}
	
	@RequestMapping(path="/users/{userName}/savedItineraryList", method=RequestMethod.GET) 
	public String showSavedItineraryList(Map<String, Object> model, @PathVariable String userName) {
		
		int itineraryId=itineraryDAO.getItineraryId();

	
		
		List <ItineraryNameLandmark> list=itineraryDAO.getItineraryAndLandmarkById(itineraryId);
		
		
		for (int i=0; i < list.size(); i++) {
			ItineraryNameLandmark itineraryNameLandmark=list.get(0);
			model.put("itineraryName", itineraryNameLandmark.getItineraryName().toUpperCase());
		}
		
		model.put("list", list);
	
		return "savedItineraryList";
		
	}
	

	
//	@RequestMapping(path={"/users/{userName}/userDashboard"}, method=RequestMethod.GET)
//	public String showHomePage(Map<String, Object> model, HttpServletRequest request) {
//		model.put("landmarks", landmarksDAO.getLandmarks());
//		List <Hotels> hotelList= hotelsDAO.getHotels();
//		request.setAttribute("hotelList", hotelList);
//	
//		return "userDashboard";
//	}

		
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
	
	@RequestMapping(path="/users/{userName}/adminLanding", method=RequestMethod.GET)
	public String displayNewAdminForm(HttpServletRequest request) {
		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
		request.setAttribute("landmarkList", landmarkList);
		
		return "adminLanding";
	}
	
	@RequestMapping(path="/users/{userName}/adminLanding", method=RequestMethod.POST)
	public String createAdmin(@RequestParam User user, @RequestParam String password) {
		userDAO.saveUser(user, password);
		return "adminLanding";
	}

//	@RequestMapping(path="/users/{userName}/addLandmark", method=RequestMethod.POST)
//	public String createNewLandmarkAdmin(@RequestParam LandmarkSuggestions suggestion ) {
//		landmarkSuggestionsDAO.save(suggestion);
//		return "addLandmark";
//	}
	

}
