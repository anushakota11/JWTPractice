package com.example.polls.repository;

import java.util.List;
import java.util.Optional;

import com.example.polls.model.User;

public interface UserRespository {
	
	Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findById(Long id);

	User save(User user);

}
