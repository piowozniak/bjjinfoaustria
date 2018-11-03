package pl.bjjinfoaustria.dto;

import java.util.ArrayList;
import java.util.List;

import pl.bjjinfoaustria.entity.Competitor;

public class Round {
	
	private boolean activeRound = false;
	private boolean winners = false;
	private boolean submitButtonActive = false;
	private long numberOfCompetitorsInRound;
	private List<Competitor> listOfCompetitorsInRound = new ArrayList<>();
	private List<Bracket> fightsForNextRound = new ArrayList<>();
	private List<Bracket> fightsInRound = new ArrayList<>();
	
	public Round() {
		super();
	}
	
	public void initializeBracketsForNextRound() {
		int numberOfFightsNextRound = fightsInRound.size()/2;
		for(int i = 1; i<=numberOfFightsNextRound; i++) {
			fightsForNextRound.add(new Bracket(i));
		}
	}
	private void addFightersToNextRoundBrackets( ) {
		for (Bracket b : getFightsInRound()) {
			addFighter(b.getWinner());
		}
	}
	private void addFighter(Competitor competitor ) {
		for ( Bracket b : getFightsForNextRound()) {
			if (b.getCompetitors().size()>2) {
				competitor.setRound(competitor.getRound()+1);
				competitor.setBracket(Integer.toString(b.getNumberOfFightInDivision()));
				b.getCompetitors().add(competitor);
			}
		}
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
	public boolean isWinners() {
		return winners;
	}
	public void setWinners(boolean winners) {
		this.winners = winners;
	}
	public List<Competitor> getListOfCompetitorsInRound() {
		return listOfCompetitorsInRound;
	}
	public void setListOfCompetitorsInRound(List<Competitor> listOfCompetitorsInRound) {
		this.listOfCompetitorsInRound = listOfCompetitorsInRound;
	}
	public boolean isSubmitButtonActive() {
		return submitButtonActive;
	}
	public void setSubmitButtonActive(boolean submitButtonActive) {
		this.submitButtonActive = submitButtonActive;
	}

	public List<Bracket> getFightsForNextRound() {
		return fightsForNextRound;
	}

	public void setFightsForNextRound(List<Bracket> fightsForNextRound) {
		this.fightsForNextRound = fightsForNextRound;
	}


}
