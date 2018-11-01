package pl.bjjinfoaustria.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.repository.CompetitionRepository;
import pl.bjjinfoaustria.repository.CompetitorRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.service.BracketService;
import pl.bjjinfoaustria.service.CompetitionService;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class CompetitionController {
	
	@Autowired
	BracketService bracketService;
	@Autowired
	CompetitionService competitionService;
	
	@GetMapping(path="/createbrackets/{id}")
	public String createBrackets(@PathVariable("id") long id, Model model) {
		return bracketService.createBrackets(model, id);
	}
	@RequestMapping(path="/displaydivision")
	public String displayDivision(@RequestParam("divisionId") long divisionId ,Model model) {
		System.out.println(divisionId);		
		return bracketService.displayDivision(model, divisionId);
	}
	@RequestMapping(path="/addcompetitortobracket/{index}")
	public String addCompetitor(@PathVariable("index") int index, Model model ) {
		System.out.println(index);			
		return bracketService.addCompetitor(model, index);
	}
	@RequestMapping(path="/removecompetitorfrombracket/{fightIndex}/{competitorIndex}")
	public String removeCompetitor(@PathVariable("fightIndex") int fightIndex, @PathVariable("competitorIndex") int competitorIndex, Model model ) {
		System.out.println(fightIndex);		System.out.println(competitorIndex);		
		return bracketService.removeCompetitor(model, fightIndex, competitorIndex);
	}
	@GetMapping(path="/submitbrackets")
	public String saveBrackets(Model model) {
		
		return bracketService.saveBrackets(model);
	}
	@GetMapping(path="/displaybrackets/{id}")
	public String displayCompetitionBrackets(@PathVariable("id") long id, Model model) {		
		return competitionService.displayBrackets(model, id);
	}
	@RequestMapping(path="/displaydivisionincompetition")
	public String displayCompetitionDivision(@RequestParam("divisionId") long divisionId ,Model model) {
		System.out.println(divisionId);		
		return competitionService.displayDivision(model, divisionId);
	}
	@RequestMapping(path="/addwinnertonextround/{competitorId}/{fightIndex}/{roundIndex}")
	public String addWinnerOfTheFight(@PathVariable("competitorId") long competitorId, @PathVariable("fightIndex") int fightIndex,
			@PathVariable("roundIndex") int roundIndex, Model model) {
		System.out.println(competitorId);
		System.out.println(fightIndex);
		System.out.println(roundIndex);
		return competitionService.addWinnerToTheNextRound(model, competitorId, fightIndex, roundIndex);
	}
	
	

}
