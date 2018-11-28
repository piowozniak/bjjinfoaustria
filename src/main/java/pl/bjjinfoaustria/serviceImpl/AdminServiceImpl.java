package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	final private UserRepository userRepository;
	private List<User> allUsers = new ArrayList<>();
	
	
	@Autowired
	public AdminServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public String displayUsers(Model model) {
		allUsers = userRepository.findAll();
		addToModel(model);
		return "adminpage";	
		
	}
	private void addToModel(Model model ) {
		model.addAttribute("allUsers", allUsers);
	}

	public List<User> getAllUsers() {
		return allUsers;
	}


	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}

}
