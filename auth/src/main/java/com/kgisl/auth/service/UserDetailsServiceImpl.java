package com.kgisl.auth.service;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kgisl.auth.entity.User;
import com.kgisl.auth.entity.UserDetailsImpl;
import com.kgisl.auth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user=userRepo.findByUserName(userName);
		System.out.println("inside impl "+user);
		
		if(user==null) {
			System.out.println("exception thrown");
			throw new UsernameNotFoundException(userName + "not found");
		}
		return new UserDetailsImpl(user);
	}

}