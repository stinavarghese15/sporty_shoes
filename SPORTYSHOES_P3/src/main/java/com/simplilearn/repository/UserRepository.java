package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from users u where u.first_name like %:keyword% ", nativeQuery = true)
	 List<User> findByKeyword(@Param("keyword") String keyword);
	
	
	
}
