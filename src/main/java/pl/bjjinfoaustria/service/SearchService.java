package pl.bjjinfoaustria.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Gym;
@Service
public interface SearchService {
	
	String findByName(Model model, String name);
	String findAll(Model model);
	String findCitiesByRegionAndGymsByRegion(Model model, Long id);
	String findByCity(Model model, Long id);

}
