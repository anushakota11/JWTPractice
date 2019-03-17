package com.example.polls.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.polls.model.User;
import com.example.polls.repository.UserRespository;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
    UserRespository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(()->new UsernameNotFoundException("User name not found"+usernameOrEmail));
		return UserPrincipal.create(user);
	}
	
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
					()->new UsernameNotFoundException("User not found:"+id));
		return UserPrincipal.create(user);
	}

}
