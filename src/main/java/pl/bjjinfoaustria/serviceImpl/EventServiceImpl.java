package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.Participant;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.enums.StatusE;
import pl.bjjinfoaustria.repository.CompetitionRepository;
import pl.bjjinfoaustria.repository.CompetitorRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.repository.EventRepository;
import pl.bjjinfoaustria.repository.ParticipantRepository;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.DivisionService;
import pl.bjjinfoaustria.service.EventService;

@Service
public class EventServiceImpl implements EventService, DivisionService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DivisionRepository divisionRepository;
	@Autowired
	private CompetitorRepository competitorRepository;
	private List<Division> listOfDivisions = new ArrayList<>();
	private Event event;
	
	@Override
	public String addEvent(Event event, Model model) {
		event.setStatus("SUBMITTED");
		eventRepository.saveAndFlush(event);
		if (event.getTypeOfEvent().equals("COMPETITION")) {			
			addModelAttributeIfEventIsCompetition(model, event);
			return  "competitionregistration";
		}
		System.out.println(event.getId());
		Division division = new Division();
		division.setEvent(event);
		divisionRepository.saveAndFlush(division);
		return "redirect:events";
	}
	
	@Override
	public String joinTypeOfEvent(Model model, long id) {
		event = eventRepository.findOne(id);
		EventUsersDTO eventUsersDTO = new EventUsersDTO(event);
		model.addAttribute("eventUsersDTO", eventUsersDTO);
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
	public void addParticipant(EventUsersDTO eventUsersDTO) {
//		System.out.println()
		User user = userRepository.findOne(eventUsersDTO.getIdUsera());
		Competitor competitor = new Competitor();
		competitor.setUser(user);
		Division division = event.getDivisions().get(0);
		System.out.println(division.getEvent().getNameOfEvent());
		competitor.setDivision(division);
		competitorRepository.saveAndFlush(competitor);
//		event.getParticipants().add(user);
//		eventRepository.saveAndFlush(event);
			
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
			model.addAttribute("event", event);
	}

	@Override
	public String editEvent(long id, Model model) {
		event = eventRepository.findOne(id);
		for (Division d : event.getDivisions()) {
			System.out.println(d.getId());
		}
		model.addAttribute("event", event);
		return "createevent";
	}

	@Override
	public String addCategoryToModel(Model model, long id) {
		Division division = new Division();
		event = eventRepository.findOne(id);
		division.setEvent(event);
		model.addAttribute("division", division);
		return "adddivision";
	}

	@Override
	public String addDivision(Division division, Model model) {
		listOfDivisions.add(division);
		event = eventRepository.findOne(division.getEvent().getId());
		model.addAttribute("event", event);
		model.addAttribute("listOfDivisions", listOfDivisions);
		return "competitionregistration";
	}
	@Override
	public String saveDivisionInCompetition(Event event) {
		for (Division d : listOfDivisions) {
			divisionRepository.saveAndFlush(d);
		}
		return "redirect:events";
	}
	

	@Override
	public String deleteDivision(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Division> getListOfDivisions() {
		return listOfDivisions;
	}

	public void setListOfDivisions(List<Division> listOfDivisions) {
		this.listOfDivisions = listOfDivisions;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}



}
