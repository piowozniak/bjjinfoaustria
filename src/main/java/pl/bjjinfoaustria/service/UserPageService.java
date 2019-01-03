package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.User;

public interface UserPageService {
	
	public String initUserPage(Model model);
	public String displayEvents(Model model);
	public String displayUserDetails(Model model);
	public String displayCreatedEvents(Model model);
	public String acceptUserInEvent(Model model, long id);
	public String editUser(Model model);
	public String editUserConfirmation(Model model, User user);

}
