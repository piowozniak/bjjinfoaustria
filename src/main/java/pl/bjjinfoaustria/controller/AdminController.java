package pl.bjjinfoaustria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.bjjinfoaustria.entity.User;
import pl.bjjinfoaustria.service.AdminService;

@Controller
@ComponentScan(basePackages="pl.bjjinfoaustria")
public class AdminController {
	
		
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@RequestMapping(path="/adminpage")
	public String displayAdminPage(Model model) {
		return adminService.displayUsers(model);
	}
	@RequestMapping(path="/activateuser/{id}", method = RequestMethod.GET)
	public String activateUser(@PathVariable(value="id", required=false) long id, Model model ) {
		System.out.println(id);
		return adminService.dislayUserToActivateOrDeactivate(model, id);
	}
	@PostMapping(path="/confirmuseractivation")
	public String confirmUser(Model model, @ModelAttribute("user") User user ) {
		System.out.println(user.getUserName());
		System.out.println(user.getId());
		return adminService.confirmUser(model, user);
	}
	

}
