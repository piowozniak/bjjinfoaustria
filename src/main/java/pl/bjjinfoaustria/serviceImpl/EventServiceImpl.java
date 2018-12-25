package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.bean.SecurityContext;
import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.enums.EventE;
import pl.bjjinfoaustria.enums.StatusE;
import pl.bjjinfoaustria.repository.CompetitorRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.repository.EventRepository;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.DivisionService;
import pl.bjjinfoaustria.service.EventService;
import pl.bjjinfoaustria.service.ModelService;
import pl.bjjinfoaustria.service.SecurityService;

@Service
public class EventServiceImpl implements EventService, DivisionService, ModelService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DivisionRepository divisionRepository;	
	@Autowired
	private CompetitorRepository competitorRepository;	
	
	private static Optional<Division> divCheck;
	private List<Division> listOfDivisions = new ArrayList<>();
	private Event event;
	private List<Event> events = new ArrayList<>();
	private List<Division> temporaryListOfDivisions;
	private List<Division> divisionsToRemove = new ArrayList<>();
	private boolean editEvent;
	private boolean displayDraftOrSubmitField = false;
	private final String[] displayEvents = {"Camp", "Seminar", "Competition"};
	private String username;
	private long userId;
	private boolean isUserAddedToEvent;

	@Override
	public String initializeEventsPage(Model model) {
		username = SecurityContext.getUsername();
		userId = SecurityContext.getUserId();
		displayDraftOrSubmitField = false;
		events.clear();
		events = setEventsListByRole();
		addAttributesToModel(model);
		return "events";
	}
	
	private List<Event> setEventsListByRole() {		
		if (SecurityContext.loggedUserByRole().equals("ROLE_ADMIN")) {
			return eventRepository.findAll();
		} else if (SecurityContext.loggedUserByRole().equals("ROLE_ORGANIZER")){
			return eventRepository.findAllActiveOrByOrganizer(username);
		} 
		return eventRepository.findByStatus(StatusE.ACTIVE.getValue());
	}
	
	private List<Event> setEventsListByTypeAndRole(String camp, String seminar, String competition) {
		if (SecurityContext.loggedUserByRole().equals("ROLE_ADMIN")) {
			return eventRepository.findEventsByType(camp, seminar, competition);
		} else if (SecurityContext.loggedUserByRole().equals("ROLE_ORGANIZER")){
			return eventRepository.findEventsByTypeOrOrganizer(camp, seminar, competition, username);
		} 
		return eventRepository.findActiveEventsByType(camp, seminar, competition);
	}
	
	@Override
	public String initializeAddEventForm(Model model) {	
		Event event = new Event();
		return "createevent";
	}
	
	@Override
	public String addEvent(Event event, Model model) {
		event.setOrganizer(username);
		if (EventE.COMPETITION.getValue().equals(event.getTypeOfEvent())) {
			event.setStatus(StatusE.DRAFT.getValue());
			addModelAttributeIfEventIsCompetition(model, event);
			return "competitionregistration";
		}
		event.setStatus(StatusE.DRAFT.getValue());
		eventRepository.saveAndFlush(event);
		Division division = new Division();
		division.setEvent(event);
		divisionRepository.saveAndFlush(division);
		return "redirect:events";
	}

	@Override
	public String joinTypeOfEvent(Model model, long id) {
		event = eventRepository.findOne(id);
		EventUsersDTO eventUsersDTO = new EventUsersDTO(event);
		model.addAttribute("event", event);
		model.addAttribute("eventUsersDTO", eventUsersDTO);
		if (event.getTypeOfEvent().equals(EventE.COMPETITION.getValue())) {
			List<Division> divisions = divisionRepository.findDivisionsFromCompetitionByEventId(id);
			model.addAttribute("divisions", divisions);
		}
		return "addusertoevent";
	}

	@Override
	public void addParticipant(EventUsersDTO eventUsersDTO, Model model) {
		User user = userRepository.findByUsername(username);
		Competitor competitor = new Competitor();
		competitor.setUser(user);
		competitor.setStatus(StatusE.SUBMITTED.getValue());
		Division division = event.getDivisions().stream().filter(Objects::nonNull).findFirst().get();
		
		divCheck = Optional.ofNullable(eventUsersDTO.getDivision());
		if (divCheck.isPresent()) {
			division = divisionRepository.findOne(eventUsersDTO.getDivision().getId());
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
	public String displayEventsByType(Model model, String camp, String seminar, String competition) {
		events.clear();
		events = (seminar == null && camp == null && competition == null) ? 
				setEventsListByRole() : setEventsListByTypeAndRole(camp, seminar, competition);
		addAttributesToModel(model);
		return "events";
	}

	@Override
	public String activateOrDeactivateEvent(Model model, long id) {
		Event event = eventRepository.findOne(id);
		String status = event.getStatus().equals(StatusE.SUBMITTED.getValue()) 
				|| event.getStatus().equals(StatusE.NONACTIVE.getValue()) ? StatusE.ACTIVE.getValue() : StatusE.NONACTIVE.getValue();
		event.setStatus(status);
		eventRepository.saveAndFlush(event);
		model.addAttribute("events", eventRepository.findAll());
		return "";
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
		addAttributesToModel(model);
		return "editevent";
	}

	@Override
	public String saveEditEvent(Event event, Model model) {
		this.event = event;
//		eventRepository.saveAndFlush(this.event);
		editEvent = false;
		displayDraftOrSubmitField = true;
		model.addAttribute("displayDraftOrSubmitField", displayDraftOrSubmitField);
		model.addAttribute("event", event);
		return "editevent";
	}
	@Override
	public String confirmDraftOrSubmit(Event event, String status, Model model) {
		this.event.setStatus(status);
		eventRepository.saveAndFlush(this.event);
		displayDraftOrSubmitField = false;
		return "";
	}

	@Override
	public void addAttributesToModel(Model model) {
		model.addAttribute("event", event);
		model.addAttribute("temporaryListOfDivisions", temporaryListOfDivisions);
		model.addAttribute("listOfDivisions", listOfDivisions);
		model.addAttribute("displayEvents", displayEvents);
		model.addAttribute("events", events);
	}

	@Override
	public String removeDivisionFromCollection(int index, Model model) {
		divisionsToRemove.add(listOfDivisions.get(index));
		listOfDivisions.remove(index);
		addAttributesToModel(model);
		return editEvent ? "editdivisions" : "competitionregistration";
	}

	@Override
	public String editDivisions(long id, Model model) {
		editEvent = true;
		event = eventRepository.findOne(id);
		listOfDivisions.clear();
		listOfDivisions = event.getDivisions();
		addAttributesToModel(model);
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
		addAttributesToModel(model);
		return editEvent ? "editdivisions" : "competitionregistration";
	}

	@Override
	public String saveDivisionInCompetition(Event event, Model model) {
		// listOfDivisions.forEach(d -> { divCheck = Optional.ofNullable(d);
		// if (divCheck.isPresent()) {
		// d.setEvent(event);
		// divisionRepository.saveAndFlush(d);
		// editEvent = false;
		// };});
//TO DO
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
				divisionRepository.delete(d);
				;
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
		isUserAddedToEvent = eventRepository.findUserInEvent(id, userId).isEmpty() ? false : true;
		model.addAttribute("event", event);
		model.addAttribute("isUserAddedToEvent", isUserAddedToEvent);
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

	public boolean isDisplayDraftOrSubmitField() {
		return displayDraftOrSubmitField;
	}

	public void setDisplayDraftOrSubmitField(boolean displayDraftOrSubmitField) {
		this.displayDraftOrSubmitField = displayDraftOrSubmitField;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserId() {
		return userId;
	}

	public boolean isUserAddedToEvent() {
		return isUserAddedToEvent;
	}
}
