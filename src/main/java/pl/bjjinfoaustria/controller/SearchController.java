package pl.bjjinfoaustria.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.entity.Region;
import pl.bjjinfoaustria.repository.GymRepository;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.SearchService;
import pl.bjjinfoaustria.service.SecurityService;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class SearchController {

	@Autowired
	GymRepository gymRepository;
	@Autowired
	SearchService searchService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SecurityService securityService;
	
	@RequestMapping("/homepage")
	public String getAllGyms(Model model) {
		String test = securityService.findLoggedInUserName();
		System.out.println(test);
//		Authentication atuthentication = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println(authentication.getName());
//		System.out.println(authentication.getAuthorities());
//		System.out.println(authentication.getDetails());
//		System.out.println(authentication.getCredentials());
//		System.out.println(authentication.getPrincipal());	
		return "homepage";
	}
	@RequestMapping("/search")
	public String initializeSearchForGymsForm(Model model) {
		return searchService.findAll(model);
	}
	
	@GetMapping("/gymsbyname")
	public String getGyms(@RequestParam("name") String name, Model model) {
		return searchService.findByName(model, name);
	}
	
	@GetMapping("/findbyregion")
	public String setCitiesFromRegionAndFindGymsByRegion(Model model, @RequestParam("regionId") Long regionId) {
		return searchService.findCitiesByRegionAndGymsByRegion(model, regionId);
	}
	
	@GetMapping("/findbycity")
	public String findByCity(Model model, @RequestParam("cityId") Long cityId) {
		return searchService.findByCity(model, cityId);
	}
	
}
