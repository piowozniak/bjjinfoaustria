package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Competitor;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Long>{

}
