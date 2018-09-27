package pl.bjjinfoaustria.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.Participant;
import pl.bjjinfoaustria.entity.User;

@Service
public interface EventService {
	
	String joinTypeOfEvent(Model model, long id);
	String addEvent(Event event, Model model);
	List<Event> allEvents();
	void addParticipant(EventUsersDTO eventUsersDTO);
	Event findEventById(long id);
	void deleteEvent(Event event);
	String editEvent(long id , Model model);
	String showEventDetails(long id, Model model);
	String saveEditEvent(Event event, Model model);
	

}
