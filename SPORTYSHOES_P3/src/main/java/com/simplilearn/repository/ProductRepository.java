package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = "select * from products u where u.category like %:keyword% ", nativeQuery = true)
	 List<Product> findByKeyword(@Param("keyword") String keyword);
	
	@Query(value = "select * from products u where u.product_id like %:id% ", nativeQuery = true)
	 List<Product> findById(@Param("id") int id);
}

