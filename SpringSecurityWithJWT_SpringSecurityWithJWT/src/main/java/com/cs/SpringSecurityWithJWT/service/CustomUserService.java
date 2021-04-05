package com.cs.SpringSecurityWithJWT.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cs.SpringSecurityWithJWT.entity.User;
import com.cs.SpringSecurityWithJWT.repo.UserRepo;

@Service
public class CustomUserService  implements UserDetailsService{
   @Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	User user=	repo.findByUserName(username);
	
	return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

}
