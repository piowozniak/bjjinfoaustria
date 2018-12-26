package pl.bjjinfoaustria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.bjjinfoaustria.service.UserPageService;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class UserController {
	
	@Autowired
	private UserPageService userPageService;
	
	@RequestMapping(path="/displayuserpage")
	public String displayUserPage(Model model ) {		
		return userPageService.initUserPage(model);
	}
	
	@RequestMapping(path="/displayuserdetails")
	public String displayUserDetails(Model model) {
		return userPageService.displayUserDetails(model);
	}
	
	@RequestMapping(path="/displayusersevents")
	public String displayUserEvents(Model model) {
		return userPageService.displayEvents(model);
	}
	
	@RequestMapping(path="/displaycreatedevents")
	public String displayCreatedEvents(Model model) {
		return userPageService.displayCreatedEvents(model);
	}
	
	@RequestMapping(path="/edituserdetails")
	public String editUserDetails(Model model, @RequestParam("id")String id) {
		return "";
	}
	
	@PostMapping(path="/activateuserinevent/{id}")
	public String acceptUserInEvent(@PathVariable("id") long id, Model model) {		
		System.out.println(id);
		return userPageService.acceptUserInEvent(model, id);
	}

}
