package com.rest.API.restfulwebservices.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.API.restfulwebservices.UserBean.User;

@Component
public class UserService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Deepak", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Tanuj", LocalDate.now().minusYears(30)));
		users.add(new User(3, "Anuj", LocalDate.now().minusYears(30)));
	}
	
	public List<User> findAll(){
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	};

}