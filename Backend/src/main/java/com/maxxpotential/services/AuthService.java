package com.maxxpotential.services;

public class AuthService {
	
public boolean login(String username, String password) {
		
		//this is hardcoding - telling Java exactly what values make for a valid login
		//in reality, you'll check the database for a username/password to see if a record exists
		if(username.equals("revature1") && password.equals("password")) {
			
			return true; //true indicates successful login
			
		}
		
		return false; //unsuccessful login
	}
}
