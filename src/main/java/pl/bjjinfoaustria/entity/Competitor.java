package pl.bjjinfoaustria.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Competitor")
public class Competitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="division_id")
	private Division division;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
