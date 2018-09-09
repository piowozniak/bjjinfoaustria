package pl.bjjinfoaustria.dto;

import java.util.List;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.User;

public class EventUsersDTO {
	
	private long id;
	private List<User> listOfUsers;
	private long idEventu;
	private long idUsera;
	


	public EventUsersDTO(long idEventu) {
		super();
		this.idEventu = idEventu;
	}

	public long getIdEventu() {
		return idEventu;
	}

	public void setIdEventu(long idEventu) {
		this.idEventu = idEventu;
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
