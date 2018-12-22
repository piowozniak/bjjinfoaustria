package pl.bjjinfoaustria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.bjjinfoaustria.entity.Gym;
@Service
public interface SearchService {
	
	List<Gym> getGymsByAttributes(String name, String city, String region);
	List<Gym> findAll();
	String getTestUserName();

}
