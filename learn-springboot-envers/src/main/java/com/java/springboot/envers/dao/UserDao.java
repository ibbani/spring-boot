package com.java.springboot.envers.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.envers.domain.UserDetails;

@Repository
public interface UserDao extends JpaRepository<UserDetails, Serializable> {

	UserDetails findById(Long userId);

}
