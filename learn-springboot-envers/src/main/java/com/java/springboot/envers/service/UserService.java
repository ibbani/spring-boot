package com.java.springboot.envers.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.springboot.envers.dao.UserDao;
import com.java.springboot.envers.domain.UserDetails;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	public UserDetails fetchUser(final Long userId) {
		log.info("Fetching user...");
		UserDetails userDetails = Optional.ofNullable(userDao.findById(userId)).orElse(new UserDetails());
		return userDetails;
	}

	public UserDetails createUser(final @RequestBody UserDetails user) {
		log.info("Creating user...");
		final Date currentTime = Calendar.getInstance().getTime();
		user.setCreatedBy("Manju");
		user.setCreatedDate(new Timestamp(currentTime.getTime()));
		user.setUpdatedBy("Manju");
		user.setUpdateDate(new Timestamp(currentTime.getTime()));
		user.setRetired('N');
		return userDao.save(user);
	}

	public UserDetails updateUser(final @RequestBody UserDetails user) {
		log.info("Updating user...");
		UserDetails userDetails = userDao.findById(user.getId());
		userDetails.setFirstName(user.getFirstName());
		userDetails.setLastName(user.getLastName());
		userDetails.setEmailId(user.getEmailId());
		final Date currentTime = Calendar.getInstance().getTime();
		userDetails.setUpdatedBy("Manju");
		userDetails.setUpdateDate(new Timestamp(currentTime.getTime()));
		return userDao.save(userDetails);
	}

	public void deleteUser(final Long userId) {
		log.info("Deleting user...");
		UserDetails userDetail = userDao.findById(userId);
		userDao.delete(userDetail);
	}

	public void softDeleteUser(final Long userId) {
		log.info("Deleting user...");
		UserDetails userDetail = userDao.findById(userId);
		userDetail.setRetired('Y');
		final Date currentTime = Calendar.getInstance().getTime();
		userDetail.setUpdatedBy("Manju");
		userDetail.setUpdateDate(new Timestamp(currentTime.getTime()));
		userDao.save(userDetail);
	}

}
