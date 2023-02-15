package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.Product;
import com.simplilearn.entity.User;
import com.simplilearn.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired 
	AdminRepository adminRepository;
	
	public List<Admin > getAllAdmins(){
		
			List<Admin> admins=new ArrayList<Admin>();
			adminRepository.findAll().forEach(admin -> admins.add(admin));
			return admins;
		
	}
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	
	public List<Admin> getByPassword(String password){
		  return adminRepository.findByPassword(password);
	 }
	
	
/*	public List<Admin> getAllAdmins() {
		List<Admin> admins = new ArrayList<Admin>();
		adminRepository.findAll().forEach(admin -> admins.add(admin));
		return admins;
	}
	
	public void update(Admin admin) {
		adminRepository.save(admin);
	}*/
	

}
