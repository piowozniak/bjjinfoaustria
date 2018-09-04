package pl.bjjinfoaustria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.serviceImpl.EventServiceImpl;

//@Controller
public class EventController {
	
//	@Autowired
//	EventService eventService;
//	
//	@RequestMapping(path="/events")
//	public String allEvents(Model model) {
//		model.addAttribute(eventService.allEvents());
//		return "events";
//	}
//	
//	@RequestMapping(path="/createevent") 
//	public String createEvent(Model model) {
//		model.addAttribute("event", new Event());
//		return "createEvent";
//	}
//	@PostMapping(path="/createevent")
//	public String createEventConfirm(@ModelAttribute("event") Event event) {
//		
//		return "redirect:eventList";
//	}
	

}
