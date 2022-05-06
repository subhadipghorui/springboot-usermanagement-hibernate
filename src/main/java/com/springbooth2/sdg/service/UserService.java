package com.springbooth2.sdg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbooth2.sdg.dao.RoleRepository;
import com.springbooth2.sdg.dao.UserRepository;
import com.springbooth2.sdg.entity.Role;
import com.springbooth2.sdg.entity.User;

@Service
public class UserService {

	// Use the repository interface which we created by extending JPA
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	public User createUser(User user, int roleId) {
		// Save the User
		System.out.println("Request role :");
		System.out.println(user);
		User newUser = userRepository.save(user);
		
		// add role
		this.assigneRole(newUser, roleId);
		return newUser;
	}
	
	public List<User> createUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User updateUser(User user, int id) {
		// there is no direct update method in JPA
		// so first create user and then update
		User oldUser=null;
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(optionalUser.isPresent()) {
			oldUser=optionalUser.get();
			oldUser.setName(user.getName());
			oldUser.setAddress(user.getAddress());
			userRepository.save(oldUser);
		}else {
			return new User();
		}
		return oldUser;
		
	}
	
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User got deleted";
	}

	public User assigneRole(User newUser, int roleId) {
		Role newUserRole = roleRepository.findById(roleId).get();
		newUser.setRole(newUserRole);
		return userRepository.save(newUser);
	}
}
