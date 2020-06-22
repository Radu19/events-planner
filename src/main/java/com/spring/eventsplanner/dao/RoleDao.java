package com.spring.eventsplanner.dao;

import com.spring.eventsplanner.model.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
