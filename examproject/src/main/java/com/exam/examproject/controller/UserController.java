package com.exam.examproject.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examproject.model.Role;
import com.exam.examproject.model.User;
import com.exam.examproject.model.UserRole;
import com.exam.examproject.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		Role role = new Role();
		role.setId(15L);
		role.setRole("Normal");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		Set<UserRole> roles = new HashSet<>();
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
		
	}
	
	@GetMapping("/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUserById(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}

}
