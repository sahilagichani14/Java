package com.exam.examproject.service;

import java.util.Set;

import com.exam.examproject.model.User;
import com.exam.examproject.model.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	public User getUser(String username);
	
	public void deleteUser(Long userId);

}
