package pl.bjjinfoaustria.controller;

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
import pl.bjjinfoaustria.service.EventService;
import pl.bjjinfoaustria.serviceImpl.EventServiceImpl;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class EventController {
	
	@Autowired
	EventService eventService;
	
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
		eventService.addEvent(event);
		return "redirect:events";
	}
	@GetMapping(path="/addparticipant/{id}")
	public String addParticipant(Model model, @PathVariable long id) {		
		Participant participant = new Participant();
		participant.setIdEventu(id);
		model.addAttribute("participant", participant);
		return "addparticipant";
	}
	@PostMapping(path="/addparticipant")
	public String addParticipantForm(@ModelAttribute Participant participant) {
		eventService.addParticipant(participant);
		return "redirect:events";
	}
	
	@ModelAttribute("listOfEvents")
	public List<String> getTypeOfEvent() {
		List<String> listOfEvents = Arrays.asList("SEMINAR", "CAMP") ;
		return listOfEvents;
	}
	

}
