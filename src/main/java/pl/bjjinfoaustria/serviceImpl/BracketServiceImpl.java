package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.bean.BracketMB;
import pl.bjjinfoaustria.entity.Competitor;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.repository.EventRepository;
import pl.bjjinfoaustria.service.BracketService;
@Service
public class BracketServiceImpl implements BracketService {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private DivisionRepository divisionRepository;
	private Event event;
	private BracketMB bracket;
	private List<Division> allDivisions = new ArrayList<>();
	private List<BracketMB> divisions = new ArrayList<>();
	
	@Override
	public String createBrackets(Model model, long id) {
		initEvent(model, id);
		return "bracketcreator";
	}
	private void initEvent(Model model, long id) {
		divisions.clear();
		event = eventRepository.findOne(id);
		allDivisions = event.getDivisions().stream().filter(Objects::nonNull).collect(Collectors.toList());		
		for (Division d : allDivisions) {
			divisions.add(new BracketMB(event, d));
		}
		divisions.forEach(d -> d.initializeBracketTree());
		bracket = divisions.get(0);
		model.addAttribute("event", event);
		model.addAttribute("divisions", divisions);
		model.addAttribute("bracket", bracket);
	}
	@Override
	public String displayDivision(Model model, long id) {
		for (BracketMB d :divisions) {
			if (d.getDivision().getId() == id) {
				bracket = d;
			}
		}
		model.addAttribute("bracket", bracket);
		model.addAttribute("event", event);
		model.addAttribute("divisions", divisions);
		return "bracketcreator";
	}
	@Override
	public String addCompetitor(Model model, int index) {
		bracket.addCompetitorToFight(index);
		model.addAttribute("bracket", bracket);
		model.addAttribute("divisions", divisions);
		return "bracketcreator";
	}
	@Override
	public String removeCompetitor(Model model, long id) {
		bracket.removeCompetitorFromFight(id);
		model.addAttribute("bracket", bracket);
		model.addAttribute("divisions", divisions);
		return "bracketcreator";
	}
}
