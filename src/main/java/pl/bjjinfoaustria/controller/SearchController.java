package pl.bjjinfoaustria.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.repository.GymRepository;
import pl.bjjinfoaustria.serviceImpl.SearchServiceImpl;

@Controller
public class SearchController {

	@Autowired
	GymRepository gymRepository;
	@Autowired
	SearchServiceImpl searchServiceImpl;
	
	@RequestMapping("/")
	public String getAllGyms(Model model) {
		List<Gym> gyms = gymRepository.findAll();
		model.addAttribute("gyms", gyms);
		return "homepage";
	}
	@RequestMapping("/search")
	public String searchForGymsForm(Model model) {
		List<Gym> gyms = gymRepository.findAll();
		model.addAttribute("gyms", gyms);
		return "searchforgyms";
	}
	@GetMapping("/gymsbycity")
	public String getGyms(@RequestParam("city") String city, @RequestParam("name") String name, @RequestParam("region") String region, Model model) {
		model.addAttribute("gyms", searchServiceImpl.getGymsByAttributes(name, city, region));
		return "searchforgyms";
	}
	@ModelAttribute("cities")
	public List<String> getCities() {
		List<String> cities = Arrays.asList("VIENNA","INNSBRUCK","LINZ", "SALZBURG");
		return cities;
	}
	@ModelAttribute("regions")
	public List<String> getRegions() {
		List<String> regions = Arrays.asList("UPPER AUSTRIA","LOWER AUSTRIA","TYROL", "VORALRBERG");
		return regions;
	}
	
}
