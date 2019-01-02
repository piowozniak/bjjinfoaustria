package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.City;
import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.entity.Region;
import pl.bjjinfoaustria.repository.CityRepository;
import pl.bjjinfoaustria.repository.GymRepository;
import pl.bjjinfoaustria.repository.RegionRepository;
import pl.bjjinfoaustria.service.GymService;
import pl.bjjinfoaustria.service.ModelService;
import pl.bjjinfoaustria.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService, ModelService, GymService {
	
	@Autowired
	private GymRepository gymRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private CityRepository cityRepository;
	
	private List<Region> regions = new ArrayList<>();
	private List<City> cities = new ArrayList<>();
	private List<Gym> gyms = new ArrayList<>();
	
	@Override
	public String findByName(Model model,String name) {
		gyms.clear();
		gyms = gymRepository.findByName(name);
		return "searchforgyms";
	}

	@Override
	public String findAll(Model model) {
		gyms = gymRepository.findAll();
		regions = regionRepository.findAll();
		cities = cityRepository.findAll();
		addAttributesToModel(model);
		return "searchforgyms";
	}
	
	@Override
	public void addAttributesToModel(Model model) {
		model.addAttribute("regions", regions);
		model.addAttribute("cities", cities);
		model.addAttribute("gyms", gyms);
	}
	
	@Override
	public String findCitiesByRegionAndGymsByRegion(Model model, Long id) {
		cities.clear();
		cities = cityRepository.findCitiesByRegionId(id);
		gyms.clear();
		gyms = gymRepository.findGymsByRegion(id);
		addAttributesToModel(model);
		return "searchforgyms";
	}
	@Override
	public String findByCity(Model model, Long id) {
		gyms.clear();
		gyms = gymRepository.findGymsByCity(id);
		addAttributesToModel(model);
		return "searchforgyms";
	}

	@Override
	public String addGym(Gym gym, Model model) {
		gymRepository.save(gym);
		addAttributesToModel(model);
		return "redirect:search";
	}

	@Override
	public String editGymForm(Model model, long id) {		
		Gym gym = gymRepository.findOne(id);
		cities.clear();
		cities = cityRepository.findAll();
		model.addAttribute("gym", gym);
		addAttributesToModel(model);
		return "addgym";
	}

	@Override
	public String deleteGymForm(Model model, long id) {
		Gym gym = gymRepository.findOne(id);	
		model.addAttribute("gym", gym);
		return "deletegym"; 
	}
	
	@Override
	public String deleteGymConfirm(Gym gym1) {
		Gym gym = gymRepository.findOne(gym1.getId());
		gymRepository.delete(gym);
		return "redirect:search";
	}

	@Override
	public String addGymForm(Model model) {
		model.addAttribute("gym", new Gym());
		cities.clear();
		cities = cityRepository.findAll();
		model.addAttribute("cities", cities);
		return "addgym";
	}



}
