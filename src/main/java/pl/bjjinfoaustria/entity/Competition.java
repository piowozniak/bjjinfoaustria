package pl.bjjinfoaustria.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Competition {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nameOfTheEvent;
	private User userUrganisator;
	private Gym gymRepresented;
	private List<Competitor> competitorsList;
	private List<String> rules;
	private String signUpDate;
	private String dateOfTheEvent;
	private String fee;
	private String status;
	

}
