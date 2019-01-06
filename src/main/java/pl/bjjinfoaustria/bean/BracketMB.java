package pl.bjjinfoaustria.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.Object;
import pl.bjjinfoaustria.dto.Bracket;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.repository.CompetitorRepository;

public class BracketMB {
	private Event event;
	private Division division;
	private int numberOfFightsInRound;
	private boolean addCompetitor;
	private boolean removeCompetitor;

	private List<Bracket> fights = new ArrayList<>();
	private List<Competitor> allCompetitorsInDivision = new ArrayList<>();
	private List<Competitor> temporaryListOfCompetitors = new ArrayList<>();
	
	public BracketMB(Event event, Division division) {
		super();
		this.event = event;
		this.division = division;
		this.allCompetitorsInDivision = new ArrayList<>(division.getCompetitors());
		this.temporaryListOfCompetitors = new ArrayList<>(division.getCompetitors());
	}
	public BracketMB() {
		
	}
	public void initializeBracketTree() {
		numberOfFightsInRound = allCompetitorsInDivision.size()%2 == 0 ? allCompetitorsInDivision.size()/2 : prepareFightsWhenCompetitorsAmountIsOdd();
		for (int i = 0; i<numberOfFightsInRound; i++) {
			fights.add(new Bracket());
		}
	}
	public void addCompetitorToFight(int index) {
		Competitor competitor = temporaryListOfCompetitors.get(index);
		temporaryListOfCompetitors.remove(index);
		for (Bracket bracket : fights) {			
			if (bracket.getCompetitors().size()<2) {
				bracket.getCompetitors().add(competitor);
				break;
			}
		}
	}
	private int prepareFightsWhenCompetitorsAmountIsOdd() {
		if (allCompetitorsInDivision.size() == 1 ) {
			return 1;
		}
		return allCompetitorsInDivision.size()/2 + 1;
	}
	
	public void removeCompetitorFromFight(int fightIndex, int competitorIndex) {		
		Competitor competitor = fights.get(fightIndex).getCompetitors().get(competitorIndex);
		temporaryListOfCompetitors.add(competitor);
		fights.get(fightIndex).getCompetitors().remove(competitorIndex);
	}
	public void saveBrackets(CompetitorRepository competitorRepository) {
		for (int i = 1; i<fights.size()+1; i++) {
			saveCompetitor(fights.get(i-1), i, 0, competitorRepository);
		}
	}
	private void saveCompetitor(Bracket b, int fight, int round  , CompetitorRepository competitorRepository) {
		for (Competitor c : b.getCompetitors()) {
			c.setBracket(Integer.toString(fight));
			c.setRound(Integer.toString(round));
			competitorRepository.saveAndFlush(c);
		}
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public int getNumberOfFightsInRound() {
		return numberOfFightsInRound;
	}
	public void setNumberOfFightsInRound(int numberOfFightsInRound) {
		this.numberOfFightsInRound = numberOfFightsInRound;
	}
	public List<Competitor> getAllCompetitorsInDivision() {
		return allCompetitorsInDivision;
	}
	public void setAllCompetitorsInDivision(List<Competitor> allCompetitorsInDivision) {
		this.allCompetitorsInDivision = allCompetitorsInDivision;
	}
	public List<Competitor> getTemporaryListOfCompetitors() {
		return temporaryListOfCompetitors;
	}
	public void setTemporaryListOfCompetitors(List<Competitor> temporaryListOfCompetitors) {
		this.temporaryListOfCompetitors = temporaryListOfCompetitors;
	}
	public List<Bracket> getFights() {		
		return fights;
	}
	public void setFights(List<Bracket> fights) {
		this.fights = fights;
	}
	public boolean isAddCompetitor() {
		return addCompetitor;
	}
	public void setAddCompetitor(boolean addCompetitor) {
		this.addCompetitor = addCompetitor;
	}
	public boolean isRemoveCompetitor() {
		return removeCompetitor;
	}
	public void setRemoveCompetitor(boolean removeCompetitor) {
		this.removeCompetitor = removeCompetitor;
	}

}
