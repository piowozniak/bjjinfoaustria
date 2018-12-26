package pl.bjjinfoaustria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Division;
@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>{
	
	@Query(value = "select * from Division d where d.event_id = :eventId", 
			  nativeQuery = true)
	List<Division> findDivisionsByEventId(@Param("eventId") long eventId);
	
	@Query(value = "select * from Division d join Competitor c on c.division_id = d.id where c.user_id = :userId and d.event_id = :eventId", nativeQuery = true)
	List<Division> findCompetitorsDivisions(@Param("eventId") long eventId, @Param("userId") long userId);
}
