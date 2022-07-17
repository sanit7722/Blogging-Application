package com.blogging.sanit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogging.sanit.entities.User;
import com.blogging.sanit.exceptions.ResourceNotFoundException;
import com.blogging.sanit.repositories.UserRepo;


@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= this.userRepo.findByEmail(username)
				
		.orElseThrow(()->new ResourceNotFoundException("User ", "email", username));
		
		return user;
	}

}
