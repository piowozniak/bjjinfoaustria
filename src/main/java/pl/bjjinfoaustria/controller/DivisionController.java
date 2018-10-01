package pl.bjjinfoaustria.controller;

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

import pl.bjjinfoaustria.entity.Division;
import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.service.DivisionService;
import pl.bjjinfoaustria.service.EventService;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class DivisionController {
	
	@Autowired
	DivisionService divisionService;
	
	@GetMapping(path="/adddivision/{id}")
	public String addDivision(@PathVariable("id") long id, Model model) {
		return divisionService.addCategoryToModel(model, id);
	}
	@GetMapping(path="/editdivisions/{id}")
	public String editDivisions(@PathVariable("id") long id, Model model) {
		return divisionService.editDivisions(id, model);
	}
	
	@PostMapping(path="/adddivision")
	public String addDivision(@ModelAttribute("division") Division division, Model model) {
		return divisionService.addDivision(division, model);
	}
	@GetMapping(path="/removediv/{index}")
	public String removeDivision(@PathVariable("index") int index, Model model) {	
		return divisionService.removeDivisionFromCollection(index, model);
	}
	@RequestMapping(path="/editdivisions/{id}")
	public String editDivisionInEvent(@PathVariable("id") long id, Model model) {
		return divisionService.editDivisions(id, model);
	}
	@PostMapping(path="/saveeditdivisions")
	public String submitEditDivisions( @ModelAttribute("event") Event event, Model model) {
		divisionService.saveDivisionInCompetition(event, model);
		return "eventdetails";
	}
	
	@RequestMapping(path="/removedivision/{index}")
	public String editRemoveDivision(Model model, @PathVariable("index") int index, @ModelAttribute("event") Event event) {
		return divisionService.removeDivisionFromCollection(index, model);
	}
	
	@PostMapping(path="/createcompetition")
	public String createCompetition(@ModelAttribute("event") Event event, Model model) {
		return divisionService.saveDivisionInCompetition(event, model);
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
