package pl.bjjinfoaustria.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.Participant;
import pl.bjjinfoaustria.entity.User;

@Service
public interface EventService {
	
	String addEvent(Event event, Model model);
	List<Event> allEvents();
	void addParticipant(long idEventu, long idUsera);
	Event findEventById(long id);
	void deleteEvent(Event event);

}
