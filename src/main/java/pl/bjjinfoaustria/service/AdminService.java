package pl.bjjinfoaustria.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface AdminService {
	
	String displayUsers(Model model);

}
