package com.springbooth2.sdg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.springbooth2.sdg.dao.RoleRepository;
import com.springbooth2.sdg.dao.UserRepository;
import com.springbooth2.sdg.entity.Permission;
import com.springbooth2.sdg.entity.Role;
import com.springbooth2.sdg.entity.User;
import com.springbooth2.sdg.request.UserRequest;
import com.springbooth2.sdg.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@PostMapping()
	public User addUser(@RequestBody UserRequest userRequest) {
		System.out.println("userRequest ");
		System.out.println(userRequest.getRoleId());
		System.out.println(userRequest.getName());
		System.out.println(userRequest.getAddress());
		
		String newUserName = userRequest.getName();
		String newUserAddress = userRequest.getAddress();
		
		User newUser = new User(newUserName, newUserAddress);
		
		return userService.createUser(newUser, userRequest.getRoleId());
	}

	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable int id) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	
	
	 /***********************************************************
     * Enrole single role
     * *********************************************************/
    @PutMapping("/{userId}/enroleRole/{roleId}")
    User enrolePermission(
    		 @PathVariable int userId,
    		 @PathVariable int roleId
    		) {
    	
    	User user= userRepository.findById(userId).get();
    	Role role = roleRepository.findById(roleId).get();
    	
    	// Setter method we made in User model
    	user.setRole(role);
    	
    	
    	// We need to save the instance
    	return userRepository.save(user);
 
    }
	
}
