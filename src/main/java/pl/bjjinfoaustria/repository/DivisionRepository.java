package pl.bjjinfoaustria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Division;
@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>{
	
	@Query(value = "select d.id, d.beltCategory, d.weightCategory, d.competition_id, d.fullNameCategory "
			+ "from Division d join Competition c on c.id = d.competition_id where c.event_id = :id", 
			  nativeQuery = true)
	List<Division> findDivisionsFromCompetitionByEventId(@Param("id") long id);
	
	

}
