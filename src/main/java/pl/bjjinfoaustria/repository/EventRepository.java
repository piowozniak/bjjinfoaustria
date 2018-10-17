package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
	@Query(value = "select e.id, e.deadline, e.endDate, e.fee, e.host, e.locationAddress, e.locationCity,\n" + 
			"e.nameOfEvent, e.organizer, e.startDate, e.startHour, e.status, e.typeOfEvent from Event e \n" + 
			"left join Division d on e.id = d.event_id	where e.id = :id and d.id is not null", 
			  nativeQuery = true)
	public Event findEventById(@Param("id") long id );

}
