package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Amit", "Bhopal"));

		users.add(new User(2, "Kabir", "Pune"));

		users.add(new User(3, "Chetan", "Bengaluru"));
	}

	int countUser = 3;

	// list of all user

	public List<User> getAllUsers() {
		return this.users;
	}

	// add user

	public User createUser(User user) {
		if (user.getId() == null) {
			user.setId(++countUser);
		}
		users.add(user);

		return user;

	}

	// get user by id
	public User getUserById(int id) {

		for (User user : this.users) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null;

	}

	// delete user by id

	public User deleteUserById(int id) {

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}

		}

		return null;
	}

}
