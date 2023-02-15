package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.simplilearn.entity.User;
import com.simplilearn.repository.UserRepository;
import com.simplilearn.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userrepository;
	
	@GetMapping("/home")
	public String viewHomePage() {
		return "home";
	}
	
	
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    return "register_form";
	}
	
	
	@PostMapping("/process_register")
	public String saveUser(User user) {
		
	//	userrepository.save(user);
		userService.saveUser(user);
		return "register_success";
	}
	

	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<User> listUsers = userrepository.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
	
	
	@RequestMapping("/searchuser")
	public String searchUser() {
	    return "searchuser";
	}
	
	
	
	@GetMapping("/search")
	//@RequestMapping(path = {"/search"})
	 public String search(User user, Model model, String keyword) {
	  if(keyword!=null) {
	   List<User> list = userService.getByKeyword(keyword);
	   model.addAttribute("list", list);
	  }else {
	  List<User> list = userService.getAllUsers();
	  model.addAttribute("list", list);}
	  return "searchuser";
	 }
	
	
}
