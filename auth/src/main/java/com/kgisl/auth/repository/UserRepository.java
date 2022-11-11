package com.kgisl.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserName(String userName);
}
