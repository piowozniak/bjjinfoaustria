package pl.bjjinfoaustria.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
//	@ManyToMany(mappedBy = "participants",fetch = FetchType.LAZY)
//	private List<Event> events;
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER,  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Competitor> competitors;
	
	public List<Competitor> getCompetitors() {
		return competitors;
	}
	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
//	public List<Event> getEvents() {
//		return events;
//	}
//	public void setEvents(List<Event> events) {
//		this.events = events;
//	}

}
