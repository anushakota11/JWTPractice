package com.example.polls.repository;

import java.util.Optional;

import com.example.polls.model.Role;
import com.example.polls.model.RoleName;

public interface RoleRespository {
	Optional<Role> findByName(RoleName roleName);
}
