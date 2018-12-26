package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

public interface UserPageService {
	
	public String initUserPage(Model model);
	public String displayEvents(Model model);
	public String displayUserDetails(Model model);
	public String displayCreatedEvents(Model model);
	public String acceptUserInEvent(Model model, long id);

}
