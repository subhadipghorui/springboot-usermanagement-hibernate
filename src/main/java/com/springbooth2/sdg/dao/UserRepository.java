package com.springbooth2.sdg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbooth2.sdg.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
