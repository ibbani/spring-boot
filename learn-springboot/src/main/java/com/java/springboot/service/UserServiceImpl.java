package com.java.springboot.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.springboot.dao.UserRepository;
import com.java.springboot.domain.User;

/**
 * This class implements Spring Boot's UserDetailsService class
 * <li>Overrides loadUserByUsername()</li>
 * <li>loadUserByUsername() will be used for user authentication by Spring
 * Security (refer SecurityConfig.java)</li>
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(rollbackOn = Exception.class, value = TxType.REQUIRED)
	public User findUserByEmal(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	@Transactional(rollbackOn = Exception.class, value = TxType.REQUIRED)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = findUserByEmal(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new UserDetailsImpl(user);
	}

}
