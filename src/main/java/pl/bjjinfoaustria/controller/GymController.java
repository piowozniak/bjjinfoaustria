package pl.bjjinfoaustria.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.repository.CityRepository;
import pl.bjjinfoaustria.repository.GymRepository;
import pl.bjjinfoaustria.serviceImpl.GymServiceImpl;
import pl.bjjinfoaustria.serviceImpl.SearchServiceImpl;
import pl.bjjinfoaustria.entity.City;


@Controller
public class GymController {

	@Autowired
	GymRepository gymRepository;
	@Autowired
	CityRepository cityRepository;
	@Autowired 
	GymServiceImpl gymServiceImpl;
	
	@GetMapping(path="/add")
	public String addGymForm(Model model) {
		model.addAttribute("gym", new Gym());
		return "addgym";
	}
	
	@PostMapping(path="/add")
	public String addGym(@ModelAttribute Gym gym) {
		gymServiceImpl.addGym(gym);
		return "addgym";
	}
	
	@RequestMapping(path="/delete/{id}")
	public String deleteGym(@PathVariable("id") Long id, Model model) {
		Gym gym = gymRepository.findOne(id);
		model.addAttribute("gym", gym);
		return "deletegym";
	}
	@PostMapping(path="/delete")
	public String deleteConfirm(@ModelAttribute("gym") Gym gym) {
		gymRepository.delete(gym);
		return "redirect:search";
	}
	@RequestMapping(path="/edit/{id}")
	public String editGym(@PathVariable("id") Long id, Model model) {
		Gym gym = gymRepository.findOne(id);
		model.addAttribute("gym", gym);
		return "addgym";
	}
	@PostMapping(path="/edit")
	public String editConfirm(@ModelAttribute("gym") Gym gym) {
		gymRepository.save(gym);
		return "redirect:search";
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

	
//	@ModelAttribute("cities")
//	public List<City> cities() {
//		List<City> cities = Arrays.asList(new City(1, "VIENNA"), new City(2, "INNSBRUCK"), new City(3, "LINZ"), new City(4, "SALZBURG"));
//		return cities;
//	}
//	
//	static class City {
//		private int id;
//		private String name;
//		
//		public City(int id, String name) {
//			super();
//			this.id = id;
//			this.name = name;
//		}
//		public int getId() {
//			return id;
//		}
//		public void setId(int id) {
//			this.id = id;
//		}
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		
//	}

}
