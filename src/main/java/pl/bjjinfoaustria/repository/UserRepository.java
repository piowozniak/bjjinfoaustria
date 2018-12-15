package pl.bjjinfoaustria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.bjjinfoaustria.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value ="select * from User where userName = :userName", nativeQuery = true)
	public User findUserByUserName(@Param("userName") String userName ) ;
		

}
