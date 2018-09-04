package pl.bjjinfoaustria.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.repository.GymRepository;
import pl.bjjinfoaustria.service.GymService;

@Service
public class GymServiceImpl implements GymService {
	
	@Autowired
	GymRepository gymRepository;

	@Override
	public void addGym(Gym gym) {
		gymRepository.save(gym);		
	}

	@Override
	public Gym findGym(long id) {		
		return gymRepository.findOne(id);
	}

	@Override
	public void deleteGym(Gym gym) {
		gymRepository.delete(gym);		
	}
	

}
