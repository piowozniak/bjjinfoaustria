package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.repository.CompetitorRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.repository.EventRepository;
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
	private static Optional<Division> divCheck; 
	@Autowired
	private CompetitorRepository competitorRepository;
	private List<Division> listOfDivisions = new ArrayList<>();
	private Event event;
	private List<Division> temporaryListOfDivisions;
	private List<Division> divisionsToRemove = new ArrayList<>();
	private boolean editEvent;

	@Override
	public String addEvent(Event event, Model model) {
		if (event.getTypeOfEvent().equals("COMPETITION")) {
			addModelAttributeIfEventIsCompetition(model, event);
			return "competitionregistration";
		}
		event.setStatus("SUBMITTED");
		eventRepository.saveAndFlush(event);
		Division division = new Division();
		division.setEvent(event);
		divisionRepository.saveAndFlush(division);
		return "redirect:events";
	}

	@Override
	public String joinTypeOfEvent(Model model, long id) {
		//event = eventRepository.findOne(id);
		event = eventRepository.findEventById(id);
		EventUsersDTO eventUsersDTO = new EventUsersDTO(event);
		model.addAttribute("event", event);
		model.addAttribute("eventUsersDTO", eventUsersDTO);
		if (event.getTypeOfEvent().equals("COMPETITION")) {
			List<Division> divisions = divisionRepository.findDivisionsFromCompetitionByEventId(id);
			model.addAttribute("divisions", divisions);
		}
		return "addusertoevent";
	}

	@Override
	public List<Event> allEvents() {
		return eventRepository.findAll();
	}

	@Override
	public void addParticipant(EventUsersDTO eventUsersDTO, Model model) {
		User user = userRepository.findOne(eventUsersDTO.getIdUsera());
		Competitor competitor = new Competitor();
		competitor.setUser(user);
		Division division;
		divCheck = Optional.ofNullable(eventUsersDTO.getDivision());
		System.out.println(event.getDivisions().size());
		if (divCheck.isPresent()) {
			division = divisionRepository.findOne(eventUsersDTO.getDivision().getId());
		} else {	
			division = event.getDivisions().stream().filter(Objects::nonNull).findFirst().get();
		}	
		model.addAttribute("division", division);
		competitor.setDivision(division);
		competitorRepository.saveAndFlush(competitor);
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
		eventRepository.saveAndFlush(event);
		model.addAttribute("event", event);
	}

	@Override
	public String editEvent(long id, Model model) {
		editEvent = true;
		event = eventRepository.findOne(id);
		temporaryListOfDivisions = event.getDivisions();
		model.addAttribute("event", event);
		model.addAttribute("temporaryListOfDivisions", temporaryListOfDivisions);
		return "editevent";
	}

	@Override
	public String removeDivisionFromCollection(int index, Model model) {
		divisionsToRemove.add(listOfDivisions.get(index));
		listOfDivisions.remove(index);
		model.addAttribute("listOfDivisions", listOfDivisions);
		model.addAttribute("event", event);
		return editEvent ? "editdivisions" : "competitionregistration";
	}

	@Override
	public String saveEditEvent(Event event, Model model) {
		eventRepository.saveAndFlush(event);
		editEvent = false;
		return "redirect:events";
	}

	@Override
	public String editDivisions(long id, Model model) {
		editEvent = true;
		event = eventRepository.findOne(id);
		listOfDivisions.clear();
		listOfDivisions = event.getDivisions();
		model.addAttribute("event", event);
		model.addAttribute("listOfDivisions", listOfDivisions);
		return "editdivisions";
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
		return editEvent ? "editdivisions" : "competitionregistration";
	}

	@Override
	public String saveDivisionInCompetition(Event event, Model model) {		
		for (Division d : listOfDivisions) {
			divCheck = Optional.ofNullable(d);
			if (divCheck.isPresent()) {
				d.setEvent(event);
				divisionRepository.saveAndFlush(d);
				editEvent = false;
			}
			
		}
		for (Division d : divisionsToRemove) {
			divCheck = Optional.ofNullable(d);
			if (divCheck.isPresent()) {
				divisionRepository.delete(d);;
			}
		}
		listOfDivisions.clear();
		divisionsToRemove.clear();
		event = eventRepository.findOne(event.getId());
		model.addAttribute("event", event);
		return "redirect:events";
	}

	@Override
	public String showEventDetails(long id, Model model) {
		event = eventRepository.findOne(id);
		model.addAttribute("event", event);
		return "eventdetails";
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

	public List<Division> getTemporaryListOfDivisions() {
		return temporaryListOfDivisions;
	}

	public void setTemporaryListOfDivisions(List<Division> temporaryListOfDivisions) {
		this.temporaryListOfDivisions = temporaryListOfDivisions;
	}

	public boolean isEditEvent() {
		return editEvent;
	}

	public void setEditEvent(boolean editEvent) {
		this.editEvent = editEvent;
	}

	public List<Division> getDivisionsToRemove() {
		return divisionsToRemove;
	}

	public void setDivisionsToRemove(List<Division> divisionsToRemove) {
		this.divisionsToRemove = divisionsToRemove;
	}

}
