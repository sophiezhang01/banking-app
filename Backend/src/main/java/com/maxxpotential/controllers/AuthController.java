package com.maxxpotential.controllers;

import com.google.gson.Gson;
import com.maxxpotential.services.AuthService;
import com.maxxpotential.models.User;
import com.maxxpotential.services.AuthService;
import io.javalin.http.Handler;

public class AuthController {
	AuthService as = new AuthService();
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		User user = gson.fromJson(body, User.class);
		if(as.login(user.getUsername(),user.getPassword()) == 1) {
			ctx.req.getSession();
			ctx.status(202);
		}
		else {
			ctx.status(401);
		}
	};
}
