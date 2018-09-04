package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	

}
