package pl.bjjinfoaustria.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="Division")
public class Division {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String beltCategory;
	private String weightCategory;
	private String fullNameCategory;
//	@OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="user_id")
//	private List<User> competitors;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="event_id")
	private Event event;
	@OneToMany(mappedBy="division", fetch = FetchType.EAGER,  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Competitor> competitors;


	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBeltCategory() {
		return beltCategory;
	}

	public void setBeltCategory(String beltCategory) {
		this.beltCategory = beltCategory;
	}

	public String getWeightCategory() {
		return weightCategory;
	}

	public void setWeightCategory(String weightCategory) {
		this.weightCategory = weightCategory;
	}

//	public List<User> getCompetitors() {
//		return competitors;
//	}
//
//	public void setCompetitors(List<User> competitors) {
//		this.competitors = competitors;
//	}

	public String getFullNameCategory() {
		return this.beltCategory + " " + this.weightCategory;
	}

	public void setFullNameCategory(String fullNameCategory) {
		this.fullNameCategory = fullNameCategory;
	}


	

}
