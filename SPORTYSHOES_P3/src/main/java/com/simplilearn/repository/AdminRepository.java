package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.Product;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer> {
	
	
	@Query(value = "select * from admin a where a.admin_pwd like %:password% ", nativeQuery = true)
	 List<Admin> findByPassword(@Param("password") String password);
	
}
