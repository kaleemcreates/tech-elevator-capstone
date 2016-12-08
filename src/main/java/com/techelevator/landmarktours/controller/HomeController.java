package com.techelevator.landmarktours.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gargoylesoftware.htmlunit.javascript.host.geo.Geolocation;
import com.techelevator.landmarktours.model.HotelsDAO;
import com.techelevator.landmarktours.model.LandmarksDAO;

@Controller
public class HomeController {
	@Autowired
    //private GeolocDAO geolocDAO;
	private HotelsDAO hotelsDAO;

	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		//model.put("landmarks", landmarkDAO.getHotels(5));
	
		return "home";
	}
//    @RequestMapping(value = "/map", method = RequestMethod.GET)
//    public ModelAndView getPages(HttpServletRequest request) {
//        //Geolocation geoloc = geolocDAO.get();
//    	//HotelsDAO geoloc = hotelsDAO.getHotelById();
//        ModelAndView model = new ModelAndView("map");
//       // List<Geolocation> listGeo = geolocDAO.list();
////        List<Geolocation> listGeo = getHotelById.list();
////        model.addObject("listGeo", listGeo);
//        return model;
//    }

}
