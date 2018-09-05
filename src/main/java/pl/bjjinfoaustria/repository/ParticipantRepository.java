package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {

}
