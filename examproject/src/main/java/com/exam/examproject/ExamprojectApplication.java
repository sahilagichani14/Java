package com.exam.examproject;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.examproject.model.Role;
import com.exam.examproject.model.User;
import com.exam.examproject.model.UserRole;
import com.exam.examproject.service.UserService;

@SpringBootApplication
public class ExamprojectApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting....");
		
		/*
		 * User user = new User(); user.setFirstname("Sahil"); user.setLastname("Agi");
		 * user.setUsername("sahil14"); user.setPassword("abc");
		 * user.setEmail("sahil@gmail.com"); user.setProfile("sahil.png");
		 * 
		 * Role role1 = new Role(); role1.setId(14L); role1.setRole("Admin");
		 * 
		 * Set<UserRole> userRoleSet = new HashSet<>();
		 * 
		 * UserRole userRole = new UserRole(); userRole.setRole(role1);
		 * userRole.setUser(user); userRoleSet.add(userRole);
		 * 
		 * User createdUser = this.userService.createUser(user, userRoleSet);
		 * System.out.println(createdUser.getUsername());
		 */
		
	}

}
