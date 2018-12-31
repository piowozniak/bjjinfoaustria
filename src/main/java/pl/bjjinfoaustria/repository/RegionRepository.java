package pl.bjjinfoaustria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.Region;
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
