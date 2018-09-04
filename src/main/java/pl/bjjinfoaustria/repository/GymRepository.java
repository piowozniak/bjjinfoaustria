package pl.bjjinfoaustria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Gym;
@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {
	
	@Query(value = "SELECT * FROM gyms g WHERE g.city = :city AND g.name = :name AND g.region = :region", 
			  nativeQuery = true)
	List<Gym> findGymsByCity(@Param("city") String city, @Param("name") String name, @Param("region") String region);
	
	@Query(value = "SELECT * FROM gyms g WHERE g.city = :city", 
			  nativeQuery = true)
	List<Gym> findGymsByCity(@Param("city") String city);

}
	