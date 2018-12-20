package pl.bjjinfoaustria.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.utils.JPAUtils;

@Service
public interface EventService {
	
	String initializeAddEventForm(Model model);
	String joinTypeOfEvent(Model model, long id);
	String addEvent(Event event, Model model);
	String allEvents(Model model);
	void addParticipant(EventUsersDTO eventUsersDTO, Model model);
	Event findEventById(long id);
	String displayEventsByType(Model model, String camp, String seminar, String competition);
	String activateOrDeactivateEvent(Model model, long id);
	String editEvent(long id , Model model);
	String showEventDetails(long id, Model model);
	String saveEditEvent(Event event, Model model);
	String confirmDraftOrSubmit(Event event, String status, Model model);
	

}
