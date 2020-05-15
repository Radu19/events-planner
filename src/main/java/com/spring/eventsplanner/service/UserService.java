package com.spring.eventsplanner.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.eventsplanner.entity.User;
import com.spring.eventsplanner.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);

	public List<User> findAll();

	public void deleteById(Long theId);

	public User findById(Long id);

}
