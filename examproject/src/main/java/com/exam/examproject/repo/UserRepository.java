package com.exam.examproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examproject.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
	
}
