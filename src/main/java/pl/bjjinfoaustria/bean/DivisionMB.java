package pl.bjjinfoaustria.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.bjjinfoaustria.dto.Bracket;
import pl.bjjinfoaustria.dto.Round;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.repository.CompetitorRepository;

public class DivisionMB {
	
	@Autowired
	CompetitorRepository competitorRepository;
	
	private Event event;
	private List<Competitor> competitors = new ArrayList<>();
	private Division division;
	
	private int currentRound;
//	private List<Bracket> fights = new ArrayList<>();
	private List<Round> rounds = new ArrayList<>();
	
	public DivisionMB(Event event, Division division, List<Competitor> competitors) {
		super();
		this.event = event;	
		this.division = division;
		this.competitors = competitors;	
	}
	
	public void initializeFights() {
		initializeRounds();			
	}
	private void initializeRounds() {
		Competitor competitor = competitors.size()!=0 ? Collections.max(competitors, Comparator.comparing(c -> Integer.valueOf(c.getRound()))) : null;
		if (competitor!=null) {
			currentRound = Integer.valueOf( competitor.getRound());
			for (int round = 0; round<=currentRound; round++) {
				rounds.add(new Round());
				addFights(round);
				addFighters(round);
			}	
		}
	
	}
	private void addFights(int round) {
		long competitorsInRound = competitors.stream().filter(c->Integer.valueOf(c.getRound()) == round).count();
		int numberOfFightsInRound = (int) (competitorsInRound/2);
		for (int i = 0; i<numberOfFightsInRound; i++) {
			rounds.get(round).getFightsInRound().add(new Bracket(i+1));
		}
	}
	private void addFighters(int round) {
		for (Bracket b : rounds.get(round).getFightsInRound() ) {
			findMatchingCompetitors(b, round);
		}
	}
	private void findMatchingCompetitors(Bracket b, int round) {
		for (Competitor c : competitors) {
			if (b.getNumberOfFightInDivision()==Integer.valueOf(c.getBracket()) 
					&& b.getCompetitors().size()<2 && Integer.valueOf(c.getRound()) == round) {
				b.getCompetitors().add(c);
			}
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

//	public List<Bracket> getFights() {
//		return fights;
//	}
//
//	public void setFights(List<Bracket> fights) {
//		this.fights = fights;
//	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

}
