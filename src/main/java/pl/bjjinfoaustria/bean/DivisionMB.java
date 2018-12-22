package pl.bjjinfoaustria.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import pl.bjjinfoaustria.dto.Bracket;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.repository.CompetitorRepository;

public class DivisionMB {
	
	private Event event;
	private List<Competitor> competitors = new ArrayList<>();
	private Division division;
	private int amountOfRoundsToFinal;
	private int currentRound;
	private Competitor winnerOfDivision;
	private List<Round> rounds = new ArrayList<>();
	
	public DivisionMB(Event event, Division division, List<Competitor> competitors) {
		super();
		this.event = event;	
		this.division = division;
		this.competitors = competitors;	
	}
	
	public void initializeFights() {
		rounds.clear();
		initializeRounds();			
	}

	private void initializeRounds() {
		Competitor competitor = competitors.size()!=0 ? Collections.max(competitors, Comparator.comparing(c -> Integer.valueOf(c.getRound()))) : null;
		checkIfWinnerOfDivision( );
		if (competitor!=null) {
			currentRound = Integer.valueOf( competitor.getRound());
			long competitorsInCurrentRound = competitors.stream().filter(c-> Integer.valueOf(c.getRound()) == 0).count();
			int round = 0;
			List<Competitor> listOfCompetitorsInRound = new ArrayList<>();
			while(competitorsInCurrentRound>1) {
				rounds.add(new Round(competitorsInCurrentRound));
				addFights(round, competitorsInCurrentRound);
				addFighters(round);
				competitorsInCurrentRound = competitorsInCurrentRound/2;
				round++;					
			}
			rounds.get(currentRound).setActiveRound(true);
		}
	}
	private void checkIfWinnerOfDivision( ) {
		winnerOfDivision = competitors.stream().filter(c -> c.getPlace().equals("1") ).findAny().orElse(null);
	}

	private void addFights(int round, long competitorsInRound) {
		int numberOfFightsInRound = (int) (competitorsInRound/2);
		for (int i = 0; i<numberOfFightsInRound; i++) {
			rounds.get(round).getFightsInRound().add(new Bracket(i+1));
		}
	}
	private void addFighters(int round) {
		rounds.get(round).getFightsInRound().stream().forEach(b->findMatchingCompetitors(b, round));
	}
	private void findMatchingCompetitors(Bracket b, int round) {
		for (Competitor c : competitors) {
			if (b.getNumberOfFightInDivision()==Integer.valueOf(c.getBracket()) 
					&& b.getCompetitors().size()<2 && Integer.valueOf(c.getRound()) == round) {
				b.getCompetitors().add(c);
			}
		}
	}
	public void addWinnerToNextRound(Competitor competitor, int fightIndex, Round round ) {
		round.getFightsInRound().get(fightIndex).setWinner(competitor);
		round.getFightsInRound().get(fightIndex).setActiveButtonToAddWinner(false);
		round.setWinners(true);
		round.setSubmitButtonActive(!checkWinnersToSubmit(round));

		
	}
	public void removeWinnerFromArray(long id, Round round, int fightIndex) {
		round.getFightsInRound().stream().filter(w -> w.getWinner()!=null&&w.getWinner().getId()==id).findFirst().map(w -> { w.setWinner(null);return w;});
		round.getFightsInRound().get(fightIndex).setActiveButtonToAddWinner(true);
		round.setWinners(round.getFightsInRound().stream().anyMatch(w -> w.getWinner()!=null));
		round.setSubmitButtonActive(!checkWinnersToSubmit(round));
	}
	private boolean checkWinnersToSubmit(Round round) {
		return round.getFightsInRound().stream().anyMatch(w -> w.getWinner()==null);
	}
	public void saveCompetitorsToTheNextRound(Round round, CompetitorRepository competitorRepository) {
		round.getFightsForNextRound().forEach(b->saveCompetitors(b,competitorRepository));
		round.setActiveRound(false);
		round.setSubmitButtonActive(false);
		initializeNextRound(round);
		if (round.getFightsInRound().size()==1) {
			winnerOfDivision = round.getFightsInRound().get(0).getWinner();
			winnerOfDivision.setPlace("1");
			competitorRepository.saveAndFlush(winnerOfDivision);
		}
		
	}
	private void saveCompetitors(Bracket b, CompetitorRepository competitorRepository) {
		b.getCompetitors().forEach(c -> competitorRepository.saveAndFlush(c));
	}
	private void initializeNextRound(Round round) {
		List<Bracket> listOfFightsInNextRound = new ArrayList<>(round.getFightsForNextRound());
		if (!listOfFightsInNextRound.isEmpty()) {
			Round nextRound = rounds.get(currentRound+1);
			nextRound.setFightsInRound(listOfFightsInNextRound);
			nextRound.setActiveRound(true);
			currentRound = currentRound+1;
		}		
	}

	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public int getAmountOfRoundsToFinal() {
		return amountOfRoundsToFinal;
	}

	public void setAmountOfRoundsToFinal(int amountOfRoundsToFinal) {
		this.amountOfRoundsToFinal = amountOfRoundsToFinal;
	}

	public Competitor getWinnerOfDivision() {
		return winnerOfDivision;
	}

	public void setWinnerOfDivision(Competitor winnerOfDivision) {
		this.winnerOfDivision = winnerOfDivision;
	}


}
