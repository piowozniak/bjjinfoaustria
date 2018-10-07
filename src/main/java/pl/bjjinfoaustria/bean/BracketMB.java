package pl.bjjinfoaustria.bean;

import java.util.ArrayList;
import java.util.List;

import pl.bjjinfoaustria.dto.Bracket;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;

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
	public void initializeBracketTree() {
		numberOfFightsInRound = allCompetitorsInDivision.size()%2 == 0 ? allCompetitorsInDivision.size()/2 : null;
		for (int i = 0; i<numberOfFightsInRound; i++) {
			fights.add(new Bracket());
		}
	}
	public void addCompetitorToFight(int index) {
		addCompetitor = true;
		Competitor competitor = temporaryListOfCompetitors.get(index);
		temporaryListOfCompetitors.remove(index);
		for (Bracket bracket : fights) {
			if (addCompetitor) {
				checkFightIfEmpty(bracket, competitor);
			}
		}
	}
	private void checkFightIfEmpty(Bracket b, Competitor competitor) {
		for (int i = 0; i<b.getCompetitors().length; i++) {
			if (b.getCompetitors()[i] == null) {
				b.getCompetitors()[i] = competitor;
				addCompetitor = false;
				break;
			}
		}
	}
	
	public void removeCompetitorFromFight(long id) {		
		removeCompetitor = true;
		Competitor competitor = allCompetitorsInDivision.stream().filter(c -> c.getId() == id).findAny().get();
		temporaryListOfCompetitors.add(competitor);
		for (Bracket b : fights) {
			if (removeCompetitor) {
				removeCheck(b, id );
			}
		}
	}
	private void removeCheck(Bracket b, long id ) {
		for (int i = 0; i<b.getCompetitors().length; i++) {
			if (b.getCompetitors()[i].getId() == id ) {
				b.getCompetitors()[i] = null;
				removeCompetitor = false;
				break;
			}
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
