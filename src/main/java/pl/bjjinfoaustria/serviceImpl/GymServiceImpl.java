package pl.bjjinfoaustria.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.repository.GymRepository;
import pl.bjjinfoaustria.service.GymService;

@Component
public class GymServiceImpl implements GymService {
	
	@Autowired
	GymRepository gymRepository;

	@Override
	public void addGym(Gym gym) {
		gymRepository.save(gym);		
	}
	

}
