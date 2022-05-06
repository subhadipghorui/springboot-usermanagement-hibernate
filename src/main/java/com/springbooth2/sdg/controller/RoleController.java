package com.springbooth2.sdg.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbooth2.sdg.dao.PermissionRepository;
import com.springbooth2.sdg.dao.RoleRepository;
import com.springbooth2.sdg.entity.Permission;
import com.springbooth2.sdg.entity.Role;


@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	

	@Autowired
	PermissionRepository permissionRepository;
	
	
   @GetMapping
    List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @PostMapping
    Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }
    
    @PostMapping("/addRoles")
	public List<Role> addRoles(@RequestBody List<Role> roles) {
		return roleRepository.saveAll(roles);
	}
    

    /***********************************************************
     * Enrole single permission
     * *********************************************************/
    @PutMapping("/{roleId}/enrolePermission/{permissionId}")
    Role enrolePermission(
    		 @PathVariable int roleId,
    		 @PathVariable int permissionId
    		) {
    	
    	Role role = roleRepository.findById(roleId).get();
    	Permission permission = permissionRepository.findById(permissionId).get();
    	
    	// Method we made in Role model
    	role.enrolledPermission(permission);
    	
    	return roleRepository.save(role);
 
    }
    
    /***********************************************************
     * Remove single permission
     * *********************************************************/
    @PutMapping("/{roleId}/removePermission/{permissionId}")
    Role removePermission(
    		 @PathVariable int roleId,
    		 @PathVariable int permissionId
    		) {
    	
    	Role role = roleRepository.findById(roleId).get();
    	Permission permission = permissionRepository.findById(permissionId).get();
    	
    	// Method we made in Role model
    	role.removedPermission(permission);
    	
    	return roleRepository.save(role);
 
    }
    
    /***********************************************************
     * Save multiple permissions
     * *********************************************************/
    @PutMapping("/{roleId}/enrolePermissions")
    Role enrolePermissions(
    		 @PathVariable int roleId,
    		 @RequestBody List<Permission> permissionsArray
    		) {
    	
    	Role role = roleRepository.findById(roleId).get();
    	Set<Permission> permissionsSet = new HashSet<>();

    	    // Add values to the set
    	for(Permission p:permissionsArray) {
    		permissionsSet.add(p);
    	}
    	
    	// We are literally overriding the all the 
    	role.setPermissions(permissionsSet);
 
    	
//    	System.out.println("----------------------");
//    	System.out.println(permissionsSet);
//    	System.out.println(role);
    	
    	// We need to save the instance
    	return roleRepository.save(role);
 
    }
    
}
