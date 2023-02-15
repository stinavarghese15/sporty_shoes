package com.simplilearn.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.entity.Product;
import com.simplilearn.entity.Purchase;
import com.simplilearn.repository.PurchaseRepository;
import com.simplilearn.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	PurchaseService purchaseService;
	
	@GetMapping("/purchaseReport")
	public String purchaseReport(Model model) {
	    List<Purchase> reports = purchaseRepository.findAll();
	    model.addAttribute("purchaseReports", reports);
	     
	    return "reports";
	}
	
	
	@RequestMapping("/report_search")
	public String getReport() {
		return "report_search";
	}
	
	@RequestMapping("/date_report")
	public String getFinalReport() {
		return "date_report";
	}
	
	
	
	@GetMapping("/pur_report")
	//@RequestMapping(path = {"/search"})
	 public String reportSearch(Purchase purchase, Model model, Date date) {
	  
		purchaseService.getByDate(date);
		List<Purchase> list = purchaseService.getByDate(date);
	    model.addAttribute("listdate", list);
	    return "date_report";
	 }	
	
	
}
