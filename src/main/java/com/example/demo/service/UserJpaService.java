package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserJpaService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers()
	{
		return this.userRepository.findAll();
	}
	
	public void createUser(User user)
	{
		this.userRepository.save(user);
	}
	
	public Optional<User> getUserById(int id)
	{
		 return this.userRepository.findById(id);
	}
	
	
	public void deleteUserById(int id)
	{
		this.userRepository.deleteById(id);
	}
	
	
	

}
