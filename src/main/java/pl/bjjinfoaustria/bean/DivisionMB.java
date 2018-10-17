package pl.bjjinfoaustria.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.bjjinfoaustria.dto.Bracket;
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
	private int numberOfFightsInRound;
	private List<Bracket> fights = new ArrayList<>();
	
	public DivisionMB(Event event, List<Competitor> competitors) {
		super();
		this.event = event;	
		this.competitors = competitors;	
	}
	
	public void initializeFights() {
		addFights();
		
	}
	private void addFights() {
		numberOfFightsInRound = competitors.size()%2 == 0 ? competitors.size()/2 : null;
		for (int i = 0; i<numberOfFightsInRound; i++) {
			fights.add(new Bracket());
		}
	}
	private void addFighters() {

	}

}
