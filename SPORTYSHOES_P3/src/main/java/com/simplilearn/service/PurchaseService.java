package com.simplilearn.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Product;
import com.simplilearn.entity.Purchase;
import com.simplilearn.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	public List<Purchase> getAllPurchase() {
		List<Purchase> purchases=new ArrayList<Purchase>();
		purchaseRepository.findAll().forEach(purchase -> purchases.add(purchase));
		return purchases;
	
	}
	
	public List<Purchase> getByDate(Date date){
		  return purchaseRepository.findAllByDate(date);
		 }
	 

}
