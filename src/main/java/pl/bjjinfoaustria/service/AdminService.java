package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.bjjinfoaustria.entity.User;

@Service
public interface AdminService {
	
	String displayUsers(Model model); 
	String dislayUserToActivateOrDeactivate(Model model, long id);
	String confirmUser(Model model, User user);
	String editUser(Model model, long id ) ;
	String editUserConfirmation(Model model, User user);

}
