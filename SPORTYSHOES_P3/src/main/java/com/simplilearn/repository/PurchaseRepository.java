package com.simplilearn.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{
	
	
	
	@Query(value = "select * from purchase u where u.date_product like %:date% ", nativeQuery = true)
	List<Purchase> findAllByDate(Date date);
	
	
}
