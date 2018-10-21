package pl.bjjinfoaustria.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.repository.CompetitorRepository;

public class Bracket {
	
	private int numberOfFightInDivision;
	
	public Bracket() {
		super();
	}
	public Bracket(int numberOfFightInDivision ) {
		super();
		this.numberOfFightInDivision = numberOfFightInDivision;
	}

	private List<Competitor> competitors = new ArrayList<>();

	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}
	public int getNumberOfFightInDivision() {
		return numberOfFightInDivision;
	}
	public void setNumberOfFightInDivision(int numberOfFightInDivision) {
		this.numberOfFightInDivision = numberOfFightInDivision;
	}
	
	

}
