package com.springbooth2.sdg.request;

public class UserRequest {

//	All the field come with request
	public String name;
	public String address;
	public Integer roleId;
	
	
	public UserRequest() {
		super();
	}
	public UserRequest(String name, String address, Integer roleId) {
		super();
		this.name = name;
		this.address = address;
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
