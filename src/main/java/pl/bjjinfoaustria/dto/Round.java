package pl.bjjinfoaustria.dto;

import java.util.ArrayList;
import java.util.List;

public class Round {
	
	private List<Bracket> fightsInRound = new ArrayList<>();

	public List<Bracket> getFightsInRound() {
		return fightsInRound;
	}

	public void setFightsInRound(List<Bracket> fightsInRound) {
		this.fightsInRound = fightsInRound;
	}

}
