package com.kgisl.auth.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.auth.entity.User;
import com.kgisl.auth.service.UserService;

@RestController
@RequestMapping("/users")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@GetMapping("/")
	public List<User> getAll() {
		return userService.getAllUsers();
	}
	
	@PreAuthorize("@userSecurity.hasUserId(auth,#id)")
	@GetMapping("/{id}")
	public Optional<User> getById(int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/")
	public User create(User user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/{id}")
	public User update(User user, int id) {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		userService.deleteUser(id);
	}
}
