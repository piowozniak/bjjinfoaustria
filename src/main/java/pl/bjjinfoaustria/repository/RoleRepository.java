package pl.bjjinfoaustria.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bjjinfoaustria.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	
	
	
	

}
