package com.maxxpotential.services;

import java.util.List;
import com.maxxpotential.models.User;
import com.maxxpotential.repositories.UserDAO;

public class AuthService {
	UserDAO uDAO = new UserDAO();
	
	public int login(String username, String password) {   
    	List<User> CheckUsername = uDAO.getUserByUsername(username);
    	try{
    		User Check = CheckUsername.get(0);
    		String Username = Check.getUsername();
        	String Password = Check.getPassword();
            if (Username.equals(username) && Password.equals(password)) {
            	return 1;
            }
            else {
            	return 0;
            }
    	}
    	catch(IndexOutOfBoundsException e) {
    		System.out.println("That Username or Password didn't match our system");
    		return 0;
    	}
    	
    }
}