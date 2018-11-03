package pl.bjjinfoaustria.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.repository.CompetitorRepository;

public class Bracket {
	private boolean activeButtonToRemoveWinner = false;
	private Competitor winner;
	private boolean activeButtonToAddWinner = true;
	private int numberOfFightInDivision;
	private List<Competitor> competitors = new ArrayList<>();
	
	public Bracket() {
		super();
	}
	public Bracket(int numberOfFightInDivision ) {
		super();
		this.numberOfFightInDivision = numberOfFightInDivision;
	}

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
	public boolean isActiveButtonToAddWinner() {
		return activeButtonToAddWinner;
	}
	public void setActiveButtonToAddWinner(boolean activeButtonToAddWinner) {
		this.activeButtonToAddWinner = activeButtonToAddWinner;
	}
	public boolean isActiveButtonToRemoveWinner() {
		return activeButtonToRemoveWinner;
	}
	public void setActiveButtonToRemoveWinner(boolean activeButtonToRemoveWinner) {
		this.activeButtonToRemoveWinner = activeButtonToRemoveWinner;
	}
	public Competitor getWinner() {
		return winner;
	}
	public void setWinner(Competitor winner) {
		this.winner = winner;
	}
	
	

}
