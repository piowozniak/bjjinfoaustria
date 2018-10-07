package pl.bjjinfoaustria.dto;

import java.util.ArrayList;
import java.util.List;

import pl.bjjinfoaustria.entity.Competitor;

public class Bracket {
	
	private Competitor[] competitors = new Competitor[2];

	public Competitor[] getCompetitors() {
		return competitors;
	}

	public void setCompetitors(Competitor[] competitors) {
		this.competitors = competitors;
	}
	
	

}
