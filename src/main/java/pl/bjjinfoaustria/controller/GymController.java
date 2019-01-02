package pl.bjjinfoaustria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.service.GymService;


@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class GymController {
	
	@Autowired
	GymService gymService;
	
	@GetMapping(path="/add")
	public String addGymForm(Model model) {
		return gymService.addGymForm(model);
	}
	
	@PostMapping(path="/add")
	public String addGym(Model model,@ModelAttribute Gym gym) {		
		return gymService.addGym(gym, model);
	}
	
	@RequestMapping(path="/delete/{id}")
	public String deleteGymForm(@PathVariable("id") Long id, Model model) {
		return gymService.deleteGymForm(model, id);
	}
	@PostMapping(path="/delete")
	public String deleteConfirm(@ModelAttribute("gym") Gym gym) {
		return gymService.deleteGymConfirm(gym);
	}
	@RequestMapping(path="/edit/{id}")
	public String editGym(@PathVariable("id") Long id, Model model) {
		return gymService.editGymForm(model, id);
	}
	
	@PostMapping(path="/edit")
	public String editConfirm(Model model, @ModelAttribute("gym") Gym gym) {		
		return gymService.addGym(gym, model);
	}

}
