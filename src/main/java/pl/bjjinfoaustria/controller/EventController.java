package pl.bjjinfoaustria.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.Participant;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.repository.CompetitionRepository;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.EventService;
import pl.bjjinfoaustria.serviceImpl.EventServiceImpl;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class EventController {
	
	@Autowired
	EventService eventService;
	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping(path="/events")
	public String allEvents(Model model) {
		model.addAttribute("events", eventService.allEvents());
		model.addAttribute("users", userRepository.findAll());
		return "events";
	}
	
	@RequestMapping(path="/createevent") 
	public String createEvent(Model model) {		
		model.addAttribute("event", new Event());
		return "createevent";
	}
	@PostMapping(path="/createevent")
	public String createEventConfirm(@ModelAttribute("event") Event event, Model model) {		
		return eventService.addEvent(event, model);
	}
	
	@GetMapping(path="/deleteevent/{id}")
	public String deleteEvent(Model model, @PathVariable long id) {
		Event event = eventService.findEventById(id);
		model.addAttribute("event", event);
		return "deleteevent";
	}
	@PostMapping(path="/deleteevent")
	public String deleteEventConfirm(@ModelAttribute Event event) {
		eventService.deleteEvent(event);
		return "redirect:events";
	}
	
	@GetMapping(path="/addusertoevent/{id}")
	public String addParticipant(Model model, @PathVariable long id) {		
		EventUsersDTO eventUsers = new EventUsersDTO(id);
		model.addAttribute("eventUsers", eventUsers);
		return "addusertoevent";
	}
	@PostMapping(path="/addusertoevent")
	public String addParticipantForm(@ModelAttribute EventUsersDTO eventUsers) {
		eventService.addParticipant(eventUsers.getIdEventu(), eventUsers.getIdUsera());
		return "redirect:events";
	}
	@GetMapping(path="/deleteuser/{id}")
	public String deleteUser(Model model, @PathVariable long id) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "deleteuser";
	}
	@PostMapping(path="/deleteuser")
	public String deleteUserConfirm(@ModelAttribute User user) {
		userRepository.delete(user);
		return "redirect:events";
	}
	
	@ModelAttribute("participants" )
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@ModelAttribute("listOfEvents")
	public List<String> getTypeOfEvent() {
		List<String> listOfEvents = Arrays.asList("SEMINAR", "CAMP", "COMPETITION") ;
		return listOfEvents;
	}
	

}
