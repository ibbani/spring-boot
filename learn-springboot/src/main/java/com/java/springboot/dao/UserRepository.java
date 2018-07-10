package com.java.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findUserByEmail(String email);

}
