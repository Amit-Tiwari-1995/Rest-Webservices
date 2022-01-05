package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserJpaService;

@RestController
public class UserJpaController {

	@Autowired
	private UserJpaService UserJpaService;

	@GetMapping("/jpa/users")
	public List<User> getAllUsers() {
		return this.UserJpaService.getAllUsers();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return this.UserJpaService.getUserById(id);
	}

	@PostMapping("/jpa/users/create")
	public void createUser(@RequestBody User user) {
		this.UserJpaService.createUser(user);
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		this.UserJpaService.deleteUserById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getAllUserPost(@PathVariable int id)
	{
		Optional<User> userOptional=this.UserJpaService.getUserById(id);
		
		if(!userOptional.isPresent())
		{
			throw new UserNotFoundException("id :"+id);
		}
		
		return userOptional.get().getPost();
	}
	
}
