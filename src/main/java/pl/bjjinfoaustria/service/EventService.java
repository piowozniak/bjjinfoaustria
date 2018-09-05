package pl.bjjinfoaustria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.bjjinfoaustria.entity.Event;

@Service
public interface EventService {
	
	void addEvent(Event event);
	List<Event> allEvents();

}
