package com.maxxpotential.controllers;

import java.util.List;
import com.google.gson.Gson;
import com.maxxpotential.models.Account;
import com.maxxpotential.services.AccountService;
import io.javalin.http.Handler;

public class AccountController {
	
	AccountService as = new AccountService();
	
	public Handler getAllAccountsHandler = (ctx) -> {
		if(ctx.req.getSession(true) !=null) {
			
			List<Account> allAccounts = as.getAllAccounts();
			
			// Add the dependency into pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use Gson library to convert the java object to a JSON string
			String JSONUsers = gson.toJson(allAccounts);
			
			// Give a response body with a JSON string 
			ctx.result(JSONUsers);
			ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to get the accounts!!!");
			ctx.status(404);
		}
	};
	
	
	public Handler insertAccountHandler = (ctx) ->{
		if(ctx.req.getSession(true) !=null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Account account = gson.fromJson(body, Account.class);
			
			as.insertAccount(account);
			
			ctx.result("Account was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to add the account!!!");
			ctx.status(404);
		}
	};
	
	public Handler getAccountByIdHandler = (ctx) -> {
		if(ctx.req.getSession(true) !=null) {
			
			int accountId = Integer.parseInt(ctx.pathParam("accountId"));
			
			Account accountsById = as.getAccountById(accountId);
			
			Gson gson = new Gson();
						
			String JSONUsers = gson.toJson(accountsById);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to get the account!!!");
			ctx.status(404);
		}
	};

	public Handler updateAccountHandler = (ctx) -> {
		if(ctx.req.getSession(true) !=null) {
			
			
		int accountId = Integer.parseInt(ctx.pathParam("accountId"));
			
		Gson gson = new Gson();
			
		String body = ctx.body();
			
		Account account = gson.fromJson(body, Account.class);
			
		Account UpdateAccount = as.updateAccount(account);
			
		String JSONAccounts = gson.toJson(UpdateAccount);
			
		ctx.result(JSONAccounts);
		ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to update the account!!!");
			ctx.status(404);
		}
	};

}
