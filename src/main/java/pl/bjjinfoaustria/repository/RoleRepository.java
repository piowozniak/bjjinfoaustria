package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bjjinfoaustria.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
