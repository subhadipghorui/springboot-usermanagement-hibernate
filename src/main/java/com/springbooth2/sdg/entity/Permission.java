package com.springbooth2.sdg.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Permission {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@JsonIgnore
	 @ManyToMany(mappedBy = "permissions")
	private Set<Role> roles = new HashSet<>();
	
	
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Permission(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", roles=" + roles + "]";
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	
}
