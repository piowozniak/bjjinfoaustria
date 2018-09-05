package pl.bjjinfoaustria.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.enums.StatusE;
import pl.bjjinfoaustria.repository.EventRepository;
import pl.bjjinfoaustria.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;
	
	@Override
	public void addEvent(Event event) {
		event.setStatus(StatusE.SUBMITTED);
		eventRepository.saveAndFlush(event);
	}

	@Override
	public List<Event> allEvents() {
		return eventRepository.findAll();
	}
	


}
