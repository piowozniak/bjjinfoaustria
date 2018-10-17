package pl.bjjinfoaustria.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.bjjinfoaustria.entity.Event;
@Component 
@Transactional
public class JPAUtils {
	@PersistenceContext
	EntityManager entityManager;

	public JPAUtils() {
		super();
	}

	public Event getDivisions(long id) {
		return entityManager.find(Event.class, id);
	}
	
	
}
