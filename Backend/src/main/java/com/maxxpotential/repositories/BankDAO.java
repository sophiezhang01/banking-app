package com.maxxpotential.repositories;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.maxxpotential.models.Account;
import com.maxxpotential.models.AccountType;
import com.maxxpotential.models.User;

public interface BankDAO {
//	CREATE
	public void insertUser(User user);
	
	public void insertAccount(Account account);
	
//	READ
	public List<Account> getAllAccounts();
	
	public List<Account> getAccountsByUser(int userId);
	
	public List<Account> getAccountsByStatus(int statusId);
	
	public Account getAccountById(int accountId);
	
	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
//	UPDATE
	public User updateUser(User user) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	
	public Account updateAccount(Account account) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
}
