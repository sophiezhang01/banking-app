package com.maxxpotential.services;

import java.util.List;
import com.maxxpotential.models.Account;
import com.maxxpotential.repositories.AccountDAO;

public class AccountService {
	
	AccountDAO aDAO = new AccountDAO();
	
	public List<Account> getAllAccounts() {
		List<Account> account = aDAO.getAllAccounts();
		return account;
	}

	public void insertAccount(Account newAccount) {
		
		aDAO.insertAccount(newAccount);
	}
	
	public Account getAccountById(int accountId) {
		
		Account account= aDAO.getAccountById(accountId);
		return account;
	}
	
	public Account updateAccount(Account account)  {
		
		return account;
	}
	
}

