package pl.bjjinfoaustria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
		
	@Query(value="select * from Event e where (e.typeOfEvent = :camp or e.typeOfEvent = :seminar or e.typeOfEvent = :competition)"
			,nativeQuery = true)
	public List<Event> findEventsByType(@Param("camp") String camp, @Param("seminar") String seminar, @Param("competition") String competition);
	
	@Query(value="select * from Event e where (e.typeOfEvent = :camp or e.typeOfEvent = :seminar or e.typeOfEvent = :competition) "
			+ "and (e.status = 'ACTIVE' or e.organizer = :organizer)",nativeQuery = true)
	public List<Event> findEventsByTypeOrOrganizer(@Param("camp") String camp, @Param("seminar") String seminar, @Param("competition") String competition, @Param("organizer") String organizer);
	
	@Query(value="select * from Event e where (e.typeOfEvent = :camp or e.typeOfEvent = :seminar or e.typeOfEvent = :competition) "
			+ "and (e.status = 'ACTIVE')",nativeQuery = true)
	public List<Event> findActiveEventsByType(@Param("camp") String camp, @Param("seminar") String seminar, @Param("competition") String competition);
	
	@Query(value="select e.id, e.deadline, e.endDate, e.fee, e.host, e.locationAddress, e.locationCity, e.nameOfEvent, e.organizer, e.startDate, e.startHour, e.status, e.typeOfEvent from Event e  " + 
			"inner join Division d on e.id = d.event_id inner join Competitor c on d.id = c.division_id	where c.user_id = :id",nativeQuery = true)
	public List<Event> findEventsUserJoined(@Param("id") long id);
	
	public List<Event> findByOrganizer(String organizer);
	
	@Query(value="select * from Event e where e.status = 'ACTIVE' or e.organizer = :organizer",nativeQuery = true)
	public List<Event> findAllActiveOrByOrganizer(@Param ("organizer") String organizer);
	
	public List<Event> findByStatus(String status);
	
	@Query(value="select * from Event e join Division d on e.id = d.event_id join Competitor c on c.division_id = d.id where c.user_id = :userId  and e.id = :eventId",nativeQuery = true)
	public List<Event> findUserInEvent(@Param("eventId") long eventId, @Param("userId") long userId);

}
