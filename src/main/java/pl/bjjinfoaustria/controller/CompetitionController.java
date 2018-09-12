package pl.bjjinfoaustria.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.bjjinfoaustria.entity.Competition;
import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.repository.CompetitionRepository;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class CompetitionController {
	
	@Autowired
	CompetitionRepository competitionRepository;
	
	@PostMapping(path="/createcompetition")
	public String createCompetition(@ModelAttribute("competition") Competition competition, Model model) {
		System.out.println(competition.getNameOfTheEvent());
		List<Division> divisions = new ArrayList<>();
		Division division = new Division();
		divisions.add(division);
		division.setCompetition(competition);
		return "redirect:events";
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
