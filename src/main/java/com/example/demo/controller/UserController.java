package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserDaoService;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userDaoService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		User user = this.userDaoService.getUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);
		}

		return user;
	}

	@PostMapping("users/create")
	public void createUser(@RequestBody User user)  {
		this.userDaoService.createUser(user);

	}

	@DeleteMapping("users/{id}")
	public void deleteUserById(@PathVariable int id) {

		User user = this.userDaoService.deleteUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);

		}

	}

	@GetMapping("/response")
	public ResponseEntity<String> response() {
		return new ResponseEntity<>("hello", HttpStatus.CREATED);

	}

}
