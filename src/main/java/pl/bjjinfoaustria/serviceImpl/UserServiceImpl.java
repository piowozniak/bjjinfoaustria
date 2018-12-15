package pl.bjjinfoaustria.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.Event;
import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.repository.EventRepository;
import pl.bjjinfoaustria.repository.UserRepository;
import pl.bjjinfoaustria.service.ModelService;
import pl.bjjinfoaustria.service.UserService;
@Service
public class UserServiceImpl implements UserService, ModelService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private UserRepository userRepository;
//	private final 
	private User user;
	private List<Event> listOfEventsUserSignedUp = new ArrayList<>();
	
	@Override
	public String initUserPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		user = userRepository.findUserByUserName(userName);
		listOfEventsUserSignedUp.clear();
//		listOfEventsUserSignedUp = eventRepository.findEventsUserJoined(user.getId());
		addAttributesToModel(model);
		return "userpage";
	}

	@Override
	public void addAttributesToModel(Model model) {
		model.addAttribute("user", user);
		model.addAttribute("listOfEventsUserSignedUp", listOfEventsUserSignedUp);
		
	}

}
