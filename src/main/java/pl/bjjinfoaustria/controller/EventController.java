package pl.bjjinfoaustria.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.serviceImpl.EventServiceImpl;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class EventController {
	
	@Autowired
	EventServiceImpl eventServiceimpl;
	
	@RequestMapping(path="/events")
	public String allEvents(Model model) {
		model.addAttribute("events", eventServiceimpl.allEvents());
		return "events";
	}
	
	@RequestMapping(path="/createevent") 
	public String createEvent(Model model) {		
		model.addAttribute("event", new Event());
		return "createEvent";
	}
	@PostMapping(path="/createevent")
	public String createEventConfirm(@ModelAttribute("event") Event event) {
		eventServiceimpl.addEvent(event);
		return "redirect:eventList";
	}
	
	@ModelAttribute("typeOfEvent")
	public List<String> getTypeOfEvent() {
		List<String> listOfEvents = Arrays.asList("SEMINAR", "CAMP") ;
		return listOfEvents;
	}
	

}
