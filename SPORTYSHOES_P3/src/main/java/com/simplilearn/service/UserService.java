package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.simplilearn.entity.User;
import com.simplilearn.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		
		List<User> users=new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
		
	}
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	
	 public List<User> getByKeyword(String keyword){
		  return userRepository.findByKeyword(keyword);
		 }
	
	
	 public List<User> getAllShops(){
		  List<User> list =  (List<User>)userRepository.findAll();
		  return list;
		 }
	

     
	    
	  /*  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new CustomUserDetails(user);
	    }*/
	
	
	 
}
