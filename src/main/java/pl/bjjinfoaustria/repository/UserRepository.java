package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.bjjinfoaustria.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserName(String username);		

}
