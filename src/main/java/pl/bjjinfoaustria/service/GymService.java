package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;

import pl.bjjinfoaustria.entity.Gym;

@Service
public interface GymService {
	
	void addGym(Gym gym);
	Gym findGym(long id);
	void deleteGym(Gym gym);
		

}
