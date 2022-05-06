package com.springbooth2.sdg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbooth2.sdg.dao.PermissionRepository;
import com.springbooth2.sdg.entity.Permission;
import com.springbooth2.sdg.entity.Role;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
	
	
		@Autowired
		PermissionRepository permissionRepository;
		
		
	   @GetMapping
	    List<Permission> getPermissions() {
	        return permissionRepository.findAll();
	    }

	    @PostMapping
	    Permission createPermission(@RequestBody Permission permission) {
	        return permissionRepository.save(permission);
	    }
	    
	    @PostMapping("/addPermissions")
		public List<Permission> addPermissions(@RequestBody List<Permission> permissions) {
			return permissionRepository.saveAll(permissions);
		}
}
