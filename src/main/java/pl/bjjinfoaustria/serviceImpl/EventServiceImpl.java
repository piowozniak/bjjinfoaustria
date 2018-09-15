package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.Participant;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.enums.StatusE;
import pl.bjjinfoaustria.repository.CompetitionRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.repository.EventRepository;
import pl.bjjinfoaustria.repository.ParticipantRepository;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CompetitionRepository competitionRepository;
	@Autowired
	DivisionRepository divisionRepository;
	
	@Override
	public String addEvent(Event event, Model model) {
		event.setStatus("SUBMITTED");		
		if (event.getTypeOfEvent().equals("COMPETITION")) {
			eventRepository.saveAndFlush(event);
			addModelAttributeIfEventIsCompetition(model, event);
			return  "competitionregistration";
		}
		eventRepository.saveAndFlush(event);
		return "redirect:events";
	}
	
	@Override
	public String joinTypeOfEvent(Model model, long id) {
		Event event = eventRepository.findOne(id);
		EventUsersDTO eventUsers = new EventUsersDTO(id);
		model.addAttribute("eventUsers", eventUsers);
		if(event.getTypeOfEvent().equals("COMPETITION")) {
			List<Division> divisions = divisionRepository.findDivisionsFromCompetitionByEventId(id);
			model.addAttribute("divisions", divisions);			
			return "addcompetitor";
		}
		return "addusertoevent";
	}

	@Override
	public List<Event> allEvents() {
		return eventRepository.findAll();
	}

	@Override
	public void addParticipant(long eventId, long userId) {
		Event event = eventRepository.findOne(eventId);
		User user = userRepository.findOne(userId);
		event.getParticipants().add(user);
		eventRepository.saveAndFlush(event);
			
	}

	@Override
	public Event findEventById(long id) {
		return eventRepository.findOne(id);
	}

	@Override
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
	private void addModelAttributeIfEventIsCompetition(Model model, Event event) {
		Competition competition = new Competition();
		competition.setEvent(event);
		competitionRepository.saveAndFlush(competition);
		model.addAttribute("competition", competition);
	}

	@Override
	public String editEvent(long id, Model model) {
		Event event = eventRepository.findOne(id);
		if (event.getTypeOfEvent().equals("COMPETITION")) {
			model.addAttribute("competition", event.getCompetition());
			return "competitionregistration";
		}
		model.addAttribute("event", event);
		return "createevent";
	}




}
