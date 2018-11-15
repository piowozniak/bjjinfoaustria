package pl.bjjinfoaustria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return bracketService.displayDivision(model, divisionId);
	}
	@RequestMapping(path="/addcompetitortobracket/{index}")
	public String addCompetitor(@PathVariable("index") int index, Model model ) {
		return bracketService.addCompetitor(model, index);
	}
	@RequestMapping(path="/removecompetitorfrombracket/{fightIndex}/{competitorIndex}")
	public String removeCompetitor(@PathVariable("fightIndex") int fightIndex, @PathVariable("competitorIndex") int competitorIndex, Model model ) {		
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
		return competitionService.displayDivision(model, divisionId);
	}
	@RequestMapping(path="/addwinnertonextround/{competitorId}/{fightIndex}/{roundIndex}")
	public String addWinnerOfTheFight(@PathVariable("competitorId") long competitorId, @PathVariable("fightIndex") int fightIndex,
			@PathVariable("roundIndex") int roundIndex, Model model) {
		return competitionService.addWinnerToTheNextRound(model, competitorId, fightIndex, roundIndex);
	}
	@RequestMapping(path="/removewinnerfromarray/{competitorId}/{fightIndex}/{roundIndex}")
	public String removeWinnerOfTheFight(@PathVariable("competitorId")long competitorId, @PathVariable("fightIndex") int fightIndex,
			@PathVariable("roundIndex") int roundIndex, Model model) {
		return competitionService.removeCompetitorFromWinnerArray(model, competitorId,fightIndex, roundIndex);
	}
	@PostMapping(path="/submitwinnerstonextround/{roundIndex}")
	public String saveWinnersOfTheRound(Model model, @PathVariable("roundIndex") int roundIndex) {
		System.out.println(roundIndex);
		return competitionService.submitCompetitorsToTheNextRound(model, roundIndex);
	}

}
