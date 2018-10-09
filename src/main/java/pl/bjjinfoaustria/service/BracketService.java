package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.repository.CompetitorRepository;

@Service
public interface BracketService {
	String createBrackets(Model model, long id);
	String displayDivision(Model model, long id);
	String addCompetitor(Model model, int index);
	String removeCompetitor(Model model, int fightIndex, int competitorIndex);
	String saveBrackets(Model model);
}
