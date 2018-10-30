package pl.bjjinfoaustria.dto;

import java.util.ArrayList;
import java.util.List;

public class Round {
	
	private boolean activeRound;
	private long numberOfCompetitorsInRound;	
	private List<Bracket> fightsInRound = new ArrayList<>();
	
	public Round() {
		super();
	}
	public Round(long numberOfCompetitorsInRound) {
		this.numberOfCompetitorsInRound = numberOfCompetitorsInRound;
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

}
