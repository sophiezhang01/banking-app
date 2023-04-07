package com.maxxpotential;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.maxxpotential.controllers.AccountController;
import com.maxxpotential.controllers.AuthController;
import com.maxxpotential.controllers.UserController;
import com.maxxpotential.utils.HibernateUtil;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		
		    	UserController uc = new UserController();
		    	AccountController ac = new AccountController();
		    	AuthController atc = new AuthController();
		    	
		    	
				//use try/catch block to test database connection. Once connection is successful, 
		    	//we can comment those code.
			   /*
			   try(Session ses = HibernateUtil.getSession()) {
			    System.out.println("Connection Successful"); } catch (HibernateException e) {
			    System.out.println("Connection Failed!"); e.printStackTrace(); }
			   */
				 
		    			   		    	
		    	Javalin app = Javalin.create(
						config -> {
							config.enableCorsForAllOrigins();
						}
					).start(3000);
		    	
		    	
		    	app.post("/login", atc.loginHandler);
		    	app.get("/user",  uc.getAllUsersHandler);
				app.post("/user", uc.insertUserHandler);
				app.get("/user/{userId}", uc.getAllUsersByIdHandler);
				app.put("/user/{userId}", uc.updateUserHandler);
				
				app.get("/account",  ac.getAllAccountsHandler);
				app.post("/account", ac.insertAccountHandler);
				app.get("/account/{accountId}", ac.getAccountByIdHandler);
				app.put("/account/{accountId}", ac.updateAccountHandler);
									
			}

	}



