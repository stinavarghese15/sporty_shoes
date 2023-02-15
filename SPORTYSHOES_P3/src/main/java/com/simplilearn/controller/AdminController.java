package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.User;
import com.simplilearn.repository.AdminRepository;
import com.simplilearn.service.AdminService;



@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminRepository adminRepository;
	
	
	
	@GetMapping("/pwd_change")
	public String showPwdForm(Model model1) {
	    model1.addAttribute("admin", new Admin());
	    return "pwd_form";
	}
	
	
	
	@PostMapping("/pwdChange")
	public String saveAdmin(Admin admin) {
		
	
		adminService.saveAdmin(admin);
		return "pwdsuccess";
	}
	@RequestMapping("/pwdsuccess")
	public String pwdSuccess() {
	    return "pwdsuccess";
	}
	
	@RequestMapping("/login")
	public String loginpage() {
	    return "login";
	}

	
	
	@PostMapping("/process_login")
	public String login(Admin admin,String password) {
		adminService.getByPassword(password);
		if(password!=(admin.getAdminPwd()))
		{

			System.out.println("failes");
		}
		else {
			System.out.println("success");
		}
		return "loginSuccess";
	}
	
	
}
	
	
	
	
	
	
	
	
	
	/*public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
	
	@RequestMapping("/pwd_form")
	public String pwdChange() {
		return "pwd_form";
	}
	
	
	@GetMapping("/pwdChange")
	public String update(Admin admin) {
		adminService.update(admin);
		return "pwdsuccess";
	}

}*/
