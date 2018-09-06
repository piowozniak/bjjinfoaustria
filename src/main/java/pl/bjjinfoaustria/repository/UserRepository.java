package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bjjinfoaustria.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
