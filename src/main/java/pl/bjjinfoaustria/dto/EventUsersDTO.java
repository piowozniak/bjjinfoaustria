package pl.bjjinfoaustria.dto;

import java.util.List;

import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.User;

public class EventUsersDTO {
	
	private long id;
	private List<User> listOfUsers;
	private Event event;
	private long idUsera;
	private Division division;
	


	public EventUsersDTO(Event event) {
		super();
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public long getIdUsera() {
		return idUsera;
	}

	public void setIdUsera(long idUsera) {
		this.idUsera = idUsera;
	}

	public EventUsersDTO() {
		super();
	}

	public List<User> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
