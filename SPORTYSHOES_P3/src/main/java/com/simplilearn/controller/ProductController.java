package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.entity.Product;
import com.simplilearn.entity.User;
import com.simplilearn.repository.ProductRepository;
import com.simplilearn.repository.UserRepository;
import com.simplilearn.service.ProductService;
import com.simplilearn.service.UserService;

@Controller
public class ProductController {


	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/productList")
	public String listProducts(Model model) {
	    List<Product> listProducts = productRepository.findAll();
	    model.addAttribute("listProducts", listProducts);
	     
	    return "products";
	}
	
	
	@RequestMapping("/searchcategory")
	public String searchCate() {
	    return "searchcategory";
	}
	
	
	
	@GetMapping("/searchfromPro")
	//@RequestMapping(path = {"/search"})
	 public String search(Product product, Model model, String keyword) {
	  if(keyword!=null) {
	   List<Product> list = productService.getByKeyword(keyword);
	   model.addAttribute("list", list);
	  }else {
	  List<Product> list = productService.getAllProducts();
	  model.addAttribute("list", list);}
	  return "searchcategory";
	 }	
	
	@RequestMapping("/deleteId")
	public String deletePro() {
	    return "deleteId";
	}
	
	@RequestMapping("/deleSuc")
	public String deletemsg() {
	    return "deleSuc";
	}
	
	@GetMapping("/deletePro")
	//@RequestMapping(path = {"/search"})
	 public String delete(Product product, Model model, int id) {
	  if(id!=0) {
		  productService.deleteProduct(id);
		  System.out.println("product Deleted");
		
	 /*  List<Product> listId = productService.getById(id);
	   model.addAttribute("listId", listId);
	  }else {
	  List<Product> list = productService.getAllProducts();
	  model.addAttribute("listId", list);}*/
	 
	  }
	  return "deleSuc";
	 }	
	
		
	
	
	
}
