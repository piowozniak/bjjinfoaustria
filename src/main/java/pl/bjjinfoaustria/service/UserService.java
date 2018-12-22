package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;

import pl.bjjinfoaustria.entity.User;

@Service
public interface UserService {

	public void save(User user);
	public User findByUserName(String username);

}
