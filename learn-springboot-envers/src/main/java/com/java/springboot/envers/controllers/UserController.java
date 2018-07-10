package com.java.springboot.envers.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.envers.domain.UserDetails;
import com.java.springboot.envers.service.UserService;

@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	/**
	 * Returns user details.
	 * 
	 * @param id Long
	 * @return UserDetails
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/users/{id}")
	public UserDetails fetchUser(@PathVariable final Long id) {
		log.info("Fetching user...");
		return userService.fetchUser(id);
	}

	/**
	 * Creates user.
	 * 
	 * @param user UserDetails
	 * @return UserDetails
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping
	public UserDetails createUser(final @RequestBody UserDetails user) {
		return userService.createUser(user);
	}

	/**
	 * Updates user. 
	 * @param id Long
	 * @param user UserDetails
	 * @return UserDetails
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/users/{id}")
	public UserDetails updateUser(@PathVariable final Long id, final @RequestBody UserDetails user) {
		user.setId(id);
		return userService.updateUser(user);
	}

	/**
	 * Deletes user.
	 * @param id Long
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable final Long id) {
		// userService.deleteUser(id);
		userService.softDeleteUser(id);
	}

}
