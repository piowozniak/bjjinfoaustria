package pl.bjjinfoaustria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Division;
@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>{
	
	@Query(value = "select d.id, d.beltCategory, d.weightCategory, d.event_id, d.fullNameCategory "
			+ "from Division d join Event e on e.id = d.event_id where d.event_id = :id", 
			  nativeQuery = true)
	List<Division> findDivisionsFromCompetitionByEventId(@Param("id") long id);
	
	

}
