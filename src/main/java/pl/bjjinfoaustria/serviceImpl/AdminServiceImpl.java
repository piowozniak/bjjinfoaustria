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
	private User user;
	private boolean displayUserConfirmation=false;
	final private String TAK = "T";
	final private String NIE = "N";
	
	
	@Autowired
	public AdminServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public String displayUsers(Model model) {
		allUsers = userRepository.findAll();
		displayUserConfirmation=false;
		addToModel(model);
		return "adminpage";	
		
	}
	@Override
	public String dislayUserToActivateOrDeactivate(Model model, long id) {
		user = userRepository.findOne(id);
		displayUserConfirmation = true;
		addToModel(model);
		return "adminpage";
	}

	@Override
	public String confirmUser(Model model, User user) {
		//TO DO refactor
		User userFromAllUsers = allUsers.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
		if (TAK.equals(userFromAllUsers.getStatus())) {
			userFromAllUsers.setStatus(NIE);
		} else if (NIE.equals(userFromAllUsers.getStatus())) {
			userFromAllUsers.setStatus(TAK);
		}
		userRepository.saveAndFlush(userFromAllUsers);
		displayUserConfirmation = false;
		addToModel(model);
		return "adminpage";
	}
	
	private void addToModel(Model model ) {
		model.addAttribute("allUsers", allUsers);
		model.addAttribute("user", user);
		model.addAttribute("displayUserConfirmation", displayUserConfirmation);
	}

	public List<User> getAllUsers() {
		return allUsers;
	}


	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public boolean isDisplayUserConfirmation() {
		return displayUserConfirmation;
	}


	public void setDisplayUserConfirmation(boolean displayUserConfirmation) {
		this.displayUserConfirmation = displayUserConfirmation;
	}



}
