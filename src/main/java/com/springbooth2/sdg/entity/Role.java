package com.springbooth2.sdg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	
	@ManyToMany
    @JoinTable(
            name = "permission_role",
            joinColumns = @JoinColumn(name="permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Permission> permissions = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private Set<User> users = new HashSet<>();


	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", permission=" + permissions + ", users=" + users + "]";
	}


	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Role() {
		super();
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
	

	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	
	public Set<Permission> getPermissions() {
		return permissions;
	}


	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}


	// Enroled Single permission
	public void enrolledPermission(Permission p) {
		permissions.add(p);
	}
	
	// Remove Single permission
		public void removedPermission(Permission p) {
			permissions.remove(p);
		}

}
