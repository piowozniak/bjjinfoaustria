package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bjjinfoaustria.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserName(String username);		

}
