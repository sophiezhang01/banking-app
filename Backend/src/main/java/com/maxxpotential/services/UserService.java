package com.maxxpotential.services;

import java.util.List;
import com.maxxpotential.models.User;
import com.maxxpotential.repositories.UserDAO;

public class UserService {
	
	UserDAO uDAO = new UserDAO(); //so that I can use the methods from the UserDAO
	
	public List<User> getAllUsers() {
		List<User> users = uDAO.getAllUsers();  //get the List of Users by calling DAO method that selects them from the database
		return users;  //return the list of users
	}

	
	public void insertUser(User newUser) {
		
		//take in the User object sent from the menu and send it to the UserDAO to be inserted into the database
		//call the DAO method that inserts the new User
		uDAO.insertUser(newUser);
	}
	
	public User getUserById(int id) {
		
		User user= uDAO.getUserById(id);
		return user;
	}
	
	public User updateUser(User user) {
		
		return uDAO.updateUser(user);
	}
	
}
