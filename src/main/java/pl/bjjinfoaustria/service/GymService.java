package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Gym;

@Service
public interface GymService {
	
	String addGymForm(Model model);
	String addGym(Gym gym, Model model);
	Gym findGym(long id);
	void deleteGym(Gym gym);
		

}
