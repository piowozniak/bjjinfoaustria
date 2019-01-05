package pl.bjjinfoaustria.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Entity(name="Event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nameOfEvent;
	private String typeOfEvent;
	private String host;
	private String organizer;
	private String startDate;
	private String endDate;
	private String startHour;
	private String deadline;
	private String locationCity;
	private String locationAddress;
	private String fee;
	private String status;
	private String registrationAvailable;
	@OneToMany(mappedBy="event", fetch = FetchType.EAGER, orphanRemoval = true)
	@OrderColumn(name = "id")
	private List<Division> divisions = new ArrayList<>(); 
	@ElementCollection
	private List<User> participants;
	
	public Event() {
		super();
	}
	public List<User> getParticipants() {
		if (this.typeOfEvent.equals("SEMINAR")) {
			List<User> users = new ArrayList<>();
			for(Competitor c : this.divisions.get(1).getCompetitors()) {
				users.add(c.getUser());
			}
			return users;
		}
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	public long getId() {
		return id;
	}
	public List<Division> getDivisions() {
		return divisions;
	}
	public void setDivisions(List<Division> divisions) {
		this.divisions.clear();
	    this.divisions.addAll(divisions);
	}
	public String getTypeOfEvent() {
		return typeOfEvent;
	}
	public void setTypeOfEvent(String typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameOfEvent() {
		return nameOfEvent;
	}
	public void setNameOfEvent(String nameOfEvent) {
		this.nameOfEvent = nameOfEvent;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartHour() {
		return startHour;
	}
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getLocationCity() {
		return locationCity;
	}
	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}
	public String getLocationAddress() {
		return locationAddress;
	}
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String string) {
		this.status = string;
	}
	public String getRegistrationAvailable() {
		return registrationAvailable;
	}
	public void setRegistrationAvailable(String registrationAvailable) {
		this.registrationAvailable = registrationAvailable;
	}
	

}
