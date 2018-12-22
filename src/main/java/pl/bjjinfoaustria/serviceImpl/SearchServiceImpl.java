package pl.bjjinfoaustria.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pl.bjjinfoaustria.entity.Gym;
import pl.bjjinfoaustria.repository.GymRepository;
import pl.bjjinfoaustria.service.SearchService;
import pl.bjjinfoaustria.service.SecurityContextService;
@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private GymRepository gymRepository;
	@Autowired
	private SecurityContextService securityContextService;
	
	@Override
	public List<Gym> getGymsByAttributes(String name, String city, String region) {
		if (name.isEmpty() && city.isEmpty() && region.isEmpty()) {
			return gymRepository.findAll();
		}
		if (name.isEmpty()) {
			return gymRepository.findGymsByCity(city);
		}
		return gymRepository.findGymsByCity(city, name, region);
	}
	@Override
	public List<Gym> findAll() {
		return gymRepository.findAll();
	}
	@Override
	public String getTestUserName() {
		return securityContextService.getUserName();
	}

}
