package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Product;

import com.simplilearn.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		
		List<Product> products=new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products;
		
	}
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
	 public List<Product> getByKeyword(String keyword){
		  return productRepository.findByKeyword(keyword);
		 }
	 
	 public List<Product> getById(int id){
		  return productRepository.findById(id);
		 }

	
}
