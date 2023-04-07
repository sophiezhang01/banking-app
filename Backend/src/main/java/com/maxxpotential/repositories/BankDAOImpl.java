package com.maxxpotential.repositories;

import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import org.hibernate.Session;
import com.maxxpotential.utils.HibernateUtil;
import com.maxxpotential.models.Account;
import com.maxxpotential.models.User;

public class BankDAOImpl implements BankDAO {
	private Session ses;
	private List<Account> accounts;
	
	public BankDAOImpl() {
		this.ses = ses;
	}

	//Hibernate DAO methods incorporate the sessions objects methods to create/manipulate data (SESSION METHODS)
	public void insertUser(User user) {
		
		//open a Session object to establish a connection to the DB
		Session ses = HibernateUtil.getSession();
		
		//insert a user into the DB
		ses.save(user);
		
		//close the Session object to prevent memory leaks
		HibernateUtil.closeSession();
	}

	public void insertAccount(Account account) {
		Session ses = HibernateUtil.getSession();
		ses.save(account);
		HibernateUtil.closeSession();
	}
	
	//HQL is best used if you're SELECTing ALL from the DB. If you want to SELECT BY, you should use sessions methods (below)
	public List<User> getAllUsers(){  //This will use SQL SELECT functionality
				
		Session ses = HibernateUtil.getSession();
				
		//SELECT all users, with HQL instead of session methods, and put the values into a List (this will be one line)
		List<User> userList = ses.createQuery("FROM User").list();
				
		HibernateUtil.closeSession();
				
		//return the List of User
		return userList; 
				
	}
	
	//Session methods are best used when you're SELECTing by the primary key, 
	//because get() and load() both expect a serializable (which our primary key is)
	public User getUserById(int id) {
			
		Session ses = HibernateUtil.getSession();
			
		//SELECT all users by ID (which should just be one user)
		User userbyid = ses.get(User.class, id);
			
		HibernateUtil.closeSession();
			
		return userbyid;	
	}

	public List<Account> getAllAccounts() {
		Session ses = HibernateUtil.getSession();
		List<Account> accountList = ses.createQuery("FROM Account").list();
		HibernateUtil.closeSession();
		return accountList; 
	}
		
	public List<Account> getAccountsByUser(int userId) {
		Session ses = HibernateUtil.getSession();
		Account accountsbyuser = ses.get(Account.class, userId);
		HibernateUtil.closeSession();
		return accounts;	
	}
		
    public List<Account> getAccountsByStatus(int statusId) {
    	Session ses = HibernateUtil.getSession();
		Account accountsbystatus = ses.get(Account.class, statusId);
		HibernateUtil.closeSession();
		return accounts;	
    }
    	
    public Account getAccountById(int accountId) {
    	Session ses = HibernateUtil.getSession();
		Account accountbyid = ses.get(Account.class, accountId);
		HibernateUtil.closeSession();
		return accountbyid;
    }
    	
    //Using session method to update
    public User updateUser(User user) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Session ses = HibernateUtil.getSession();
		Transaction tran = (Transaction) ses.beginTransaction(); //all update and delete methods must happen within a transaction
		ses.merge(user);
		tran.commit();
		//close the transaction and session
		HibernateUtil.closeSession();
		return user;
	}
    	
   	public Account updateAccount(Account account) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
    	Session ses = HibernateUtil.getSession();
		Transaction tran = (Transaction) ses.beginTransaction(); //all update and delete methods must happen within a transaction
		ses.merge(account);
		tran.commit();
		//close the transaction and session
		HibernateUtil.closeSession();
		return account;
    }
}
