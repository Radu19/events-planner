package com.spring.eventsplanner.dao;

import com.spring.eventsplanner.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
