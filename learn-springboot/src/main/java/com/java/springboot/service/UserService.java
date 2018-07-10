package com.java.springboot.service;

import com.java.springboot.domain.User;

public interface UserService {

	User findUserByEmal(String email);

}