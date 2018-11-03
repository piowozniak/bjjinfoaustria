package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Division;

@Service
public interface CompetitionService {
	String displayBrackets(Model model, long id);
	String displayDivision(Model model, long id);
	String addWinnerToTheNextRound(Model model, long id, int fightIndex, int roundIndex);
	String removeCompetitorFromWinnerArray(Model model, long id, int fightIndex, int roundIndex);
	String submitCompetitorsToTheNextRound(Model model, int roundIndex);
}
