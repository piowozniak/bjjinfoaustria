package pl.bjjinfoaustria.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.Participant;
import pl.bjjinfoaustria.entity.User;
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
		return "events";
	}
	
	@RequestMapping(path="/createevent") 
	public String createEvent(Model model) {		
		model.addAttribute("event", new Event());
		return "createevent";
	}
	@PostMapping(path="/createevent")
	public String createEventConfirm(@ModelAttribute("event") Event event) {
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Kebab");
		userRepository.save(user1);
		User user2 = new User();
		user2.setFirstName("dupa");
		user2.setLastName("cyce");
		userRepository.save(user2);

		List<User> list = new ArrayList<User>();
		event.setParticipants(list);
		event.getParticipants().add(user1);
		event.getParticipants().add(user2);
		eventService.addEvent(event);
		System.out.println(event.getParticipants().size());
		return "redirect:events";
	}
	@GetMapping(path="/adduser/{id}")
	public String addParticipant(Model model, @PathVariable long id) {		
		Event event = eventService.findEventById(id);
		System.out.println(event.getParticipants().size());
		for (User user : event.getParticipants()) {
			System.out.println(user.getFirstName());
		}
		User user = new User();
		user.getEvents().add(event);
//		user.setIdEventu(id);
		model.addAttribute("user", user);
		return "adduser";
	}
	@PostMapping(path="/adduser")
	public String addParticipantForm(@ModelAttribute User user) {
		eventService.addParticipant(user);
		return "redirect:events";
	}
	
	@ModelAttribute("listOfEvents")
	public List<String> getTypeOfEvent() {
		List<String> listOfEvents = Arrays.asList("SEMINAR", "CAMP") ;
		return listOfEvents;
	}
	

}
