package pl.bjjinfoaustria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bjjinfoaustria.service.UserService;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/displayuserpage")
	public String displayUserPage(Model model ) {
		
		return userService.initUserPage(model);
	}

}
