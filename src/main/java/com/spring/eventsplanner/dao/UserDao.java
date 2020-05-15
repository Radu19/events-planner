package com.spring.eventsplanner.dao;

import java.util.List;

import com.spring.eventsplanner.entity.User;


public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
    public List<User> findAll();

	public void deleteById(Long theId);

	public User findById(Long id);
    
}
