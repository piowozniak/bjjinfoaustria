package pl.bjjinfoaustria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Division;
@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>{
	
	@Query(value = "select * from Division where event_id = :id", 
			  nativeQuery = true)
	List<Division> findDivisionsFromCompetitionByEventId(@Param("id") long id);
	
	

}
