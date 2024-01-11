package com.demo.CarDatabase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.demo.CarDatabase.dto.AppUser;
import com.demo.CarDatabase.repositories.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByUsername(username);
		UserBuilder builder = null;
		if (user.getId() != null) {
			AppUser currentUser = user;
			builder = org.springframework.security.core.userdetails.
                    User.withUsername(username);
	          builder.password(currentUser.getPassword());
	          builder.roles(currentUser.getRole());
			
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

}
