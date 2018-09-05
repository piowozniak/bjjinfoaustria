package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
	

}
