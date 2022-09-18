package com.exam.examproject.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examproject.model.User;
import com.exam.examproject.model.UserRole;
import com.exam.examproject.repo.RoleRepository;
import com.exam.examproject.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	//this function will give user & all its associated roles
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		
		if(local!=null) {
			System.out.println("User Already Present!!");
			throw new Exception("User Already Present!!");
		}
		else {
			//getting all roles & saving all Role
			for(UserRole ur : userRoles) {
				this.roleRepository.save(ur.getRole());
			}
			//adding userRoles to user 
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);	
		}
		//since cascade all written in User.java at userRoles so it will automatically save userroles if we save user
		
		return local;
	}

	@Override
	//get user by username
	public User getUser(String username) {
		User findByUsername = this.userRepository.findByUsername(username);
		return findByUsername;
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

}
