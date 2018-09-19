package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bjjinfoaustria.entity.EventRegistration;

public interface EventUserDetailsRepository extends JpaRepository<EventRegistration, Long>{

}
