package com.maxxpotential.controllers;

import java.util.List;
import com.google.gson.Gson;
import com.maxxpotential.models.User;
import com.maxxpotential.services.UserService;
import io.javalin.http.Handler;

public class UserController {
	
	UserService us = new UserService();
	
	// *****This layer is where we'll parse our JSON into Java objects and vice versa*****
		// Sits between the Javalin Front Controller and the Service Layer
		// We'll either be getting data from the service layer (which is our DAO)
		// OR sending data to the service layer (will probably return some response that it was successful)
	
	public Handler getAllUsersHandler = (ctx) -> {
		if(ctx.req.getSession(true) !=null) { //if the session exists
			
			List<User> allUsers = us.getAllUsers();
			
			// Add the dependency into pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use Gson library to convert the java object to a JSON string
			String JSONUsers = gson.toJson(allUsers);
			
			// Give a response body with a JSON string 
			ctx.result(JSONUsers);
			ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to get the users!!!");
			ctx.status(404);
		}
	};
	
	public Handler getAllUsersByIdHandler = (ctx) -> {
		if(ctx.req.getSession(true) !=null) {
			
			int userId = Integer.parseInt(ctx.pathParam("userId"));
			
			User UsersById = us.getUserById(userId);
			
			Gson gson = new Gson();
						
			String JSONUsers = gson.toJson(UsersById);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to get the user!!!");
			ctx.status(404);
		}
	};
	
	public Handler getUserByUsernameHandler = ctx -> {
        if(ctx.req.getSession() != null) {
	        try {	
	            String username =ctx.pathParam("username") ;
	            List<User> user = us.getUserByUsername(username);
	            Gson gson = new Gson();
	            String JSONEmployees = gson.toJson(user);
	            ctx.result(JSONEmployees);
	            ctx.status(200);
	        }
	        catch(Exception e) {
				ctx.status(404);	
			}
        } 
		else {
			ctx.status(403);
		}
    };	
	
	public Handler insertUserHandler = (ctx) ->{
		if(ctx.req.getSession(true) !=null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User user = gson.fromJson(body, User.class);
			
			us.insertUser(user);
			
			ctx.result("User was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to add the user!!!");
			ctx.status(404);
		}
	};

	public Handler updateUserHandler = (ctx) -> {
		if(ctx.req.getSession(true) !=null) {
			
		int userId = Integer.parseInt(ctx.pathParam("userId"));
			
		Gson gson = new Gson();
			
		String body = ctx.body();
			
		User user = gson.fromJson(body, User.class);
			
		User UpdateUser = us.updateUser(user);
			
		String JSONUsers = gson.toJson(UpdateUser);
			
		ctx.result(JSONUsers);
		ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to update the user!!!");
			ctx.status(404);
		}
	};
	
	public Handler deleteUserHandler = ctx -> {
		if(ctx.req.getSession() != null) {
			try {	
	            int userId = Integer.parseInt(ctx.pathParam("userId"));
		        System.out.println(userId);	        
				us.deleteUser(userId);
				ctx.status(202);
			}
			catch(Exception e) {
				e.printStackTrace();
				ctx.status(404);	
			}
		} 
		else {
			ctx.status(403);
		}	
	};

}
