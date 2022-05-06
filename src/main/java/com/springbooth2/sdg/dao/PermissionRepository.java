package com.springbooth2.sdg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbooth2.sdg.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
