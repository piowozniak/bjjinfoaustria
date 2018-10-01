package pl.bjjinfoaustria.bean;

import java.util.ArrayList;
import java.util.List;

import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;

public class DivisionMB {
	
	private Event event;
	private List<Competitor> competitors = new ArrayList<>();
	private Division division;
}
