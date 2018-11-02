package pl.bjjinfoaustria.dto;

import java.util.ArrayList;
import java.util.List;

import pl.bjjinfoaustria.entity.Competitor;

public class Round {
	
	private boolean activeRound = false;
	private boolean winners = false;
	private boolean submitButton = false;
	private long numberOfCompetitorsInRound;
	private List<Competitor> listOfCompetitorsInRound = new ArrayList<>();
	private Competitor[] listOfWinners;
	private List<Bracket> fightsInRound = new ArrayList<>();
	
	public Round() {
		super();
	}
	public Round(long numberOfCompetitorsInRound) {
		this.numberOfCompetitorsInRound = numberOfCompetitorsInRound;
		this.listOfWinners = new Competitor[(int) (numberOfCompetitorsInRound)];
	}

	public List<Bracket> getFightsInRound() {
		return fightsInRound;
	}

	public void setFightsInRound(List<Bracket> fightsInRound) {
		this.fightsInRound = fightsInRound;
	}
	public long getNumberOfCompetitorsInRound() {
		return numberOfCompetitorsInRound;
	}
	public void setNumberOfCompetitorsInRound(long numberOfCompetitorsInRound) {
		this.numberOfCompetitorsInRound = numberOfCompetitorsInRound;
	}
	public boolean isActiveRound() {
		return activeRound;
	}
	public void setActiveRound(boolean activeRound) {
		this.activeRound = activeRound;
	}
	public boolean isWinners() {
		return winners;
	}
	public void setWinners(boolean winners) {
		this.winners = winners;
	}
	public Competitor[] getListOfWinners() {
		return listOfWinners;
	}
	public void setListOfWinners(Competitor[] listOfWinners) {
		this.listOfWinners = listOfWinners;
	}
	public List<Competitor> getListOfCompetitorsInRound() {
		return listOfCompetitorsInRound;
	}
	public void setListOfCompetitorsInRound(List<Competitor> listOfCompetitorsInRound) {
		this.listOfCompetitorsInRound = listOfCompetitorsInRound;
	}

}
