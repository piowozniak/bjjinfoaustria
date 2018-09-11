package pl.bjjinfoaustria.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Competition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nameOfTheEvent;	
	@OneToOne(mappedBy="competition", fetch = FetchType.LAZY)
	private Event event;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameOfTheEvent() {
		return nameOfTheEvent;
	}
	public void setNameOfTheEvent(String nameOfTheEvent) {
		this.nameOfTheEvent = nameOfTheEvent;

	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	

}
