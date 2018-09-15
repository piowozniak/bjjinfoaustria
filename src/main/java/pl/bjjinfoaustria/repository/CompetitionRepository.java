package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Competition;
@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long>{

}
