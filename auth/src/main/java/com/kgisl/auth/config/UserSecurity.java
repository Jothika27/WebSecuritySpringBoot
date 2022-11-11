package com.kgisl.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Component;

import com.kgisl.auth.repository.UserRepository;

@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	UserRepository userRepo;
	
	public boolean hasUserId(Authentication auth, Integer userId) {	
		int userID=userRepo.findByUserName(auth.getUsername()).getId();
		System.out.println(userId+"  "+userID);
            if(userID==userId)
            	return true;
            
            return false;
       
    }
}