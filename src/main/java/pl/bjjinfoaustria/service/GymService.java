package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Gym;

@Service
public interface GymService {
	
	String addGymForm(Model model);
	String addGym(Gym gym, Model model);
	String editGymForm(Model model, long id);
	String deleteGymForm(Model model, long id);
	String deleteGymConfirm(Gym gym);
	
		

}
