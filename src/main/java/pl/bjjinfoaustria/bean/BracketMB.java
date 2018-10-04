package pl.bjjinfoaustria.bean;

import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;

public class BracketMB {
	
	private Event event;
	private Division division;
	
	public BracketMB(Division division) {
		super();
		this.division = division;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}
	
	

}
