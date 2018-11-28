package pl.bjjinfoaustria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	

}
