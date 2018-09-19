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

import pl.bjjinfoaustria.dto.EventUsersDTO;
import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.repository.CompetitionRepository;
import pl.bjjinfoaustria.repository.DivisionRepository;
import pl.bjjinfoaustria.service.CompetitionService;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class CompetitionController {
	
	@Autowired
	CompetitionService competitionService;
	@Autowired
	DivisionRepository divisionRepository;
	@Autowired
	CompetitionRepository competitionRepository;
	
	@PostMapping(path="/createcompetition")
	public String createCompetition(@ModelAttribute("competition") Competition competition, Model model) {
		return "redirect:events";
	}
	@GetMapping(path="/adddivision/{id}")
	public String addDivision(@PathVariable("id") long id, Model model) {
		return competitionService.addCategoryToModel(model, id);
	}
	@PostMapping(path="/adddivision")
	public String addDivision(@ModelAttribute("division") Division division, Model model) {
		return competitionService.saveDivision(division, model);
	}	
	@PostMapping(path="/addcompetitor")
	public String addCompetitor(@ModelAttribute("eventUsers") EventUsersDTO eventUsers, Model model ) {
		System.out.println(model.containsAttribute("eventUsers"));
		System.out.println(eventUsers.getIdEventu() + "   id eventu");
		System.out.println(eventUsers.getIdUsera() + "   id usera");
		System.out.println(eventUsers.getDivision().getId() + "   id division");
		
		return competitionService.addCompetitor(eventUsers.getIdEventu(), eventUsers.getIdUsera(), eventUsers.getDivision());
	}
	
	@ModelAttribute("beltCategories")
	public List<String> getBeltCategories() {
		List <String> beltCategories = Arrays.asList("WHITE", "BLUE", "PURPLE", "BROWN", "BLACK");
		return beltCategories;
	}
	@ModelAttribute("weightCategories")
	public List<String> getWeightCategories() {
		List <String> beltCategories = 
				Arrays.asList("-57kg", "-64kg", "-70kg", "-76kg", "-82,3kg", "-88,3kg", "-94,3kg", "-100,5 kg", "+100,5kg");
		return beltCategories;
	}
	
	

}
