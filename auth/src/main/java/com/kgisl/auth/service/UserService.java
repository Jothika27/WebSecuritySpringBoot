package com.kgisl.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.auth.entity.User;
import com.kgisl.auth.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user, int id) {
		return userRepository.save(user);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
