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

public class AccountDAO {
	
	public void insertAccount(Account account) {
		Session ses = HibernateUtil.getSession();
		ses.save(account);
		HibernateUtil.closeSession();
	}
	
	public List<Account> getAllAccounts() {
		Session ses = HibernateUtil.getSession();
		List<Account> accountList = ses.createQuery("FROM Account").list();
		HibernateUtil.closeSession();
		return accountList; 
	}
		
	public Account getAccountById(int accountId) {
    	Session ses = HibernateUtil.getSession();
		Account account = ses.get(Account.class, accountId);
		HibernateUtil.closeSession();
		return account;
    }
    	
    public Account updateAccount(Account account) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
    	Session ses = HibernateUtil.getSession();
		Transaction tran = (Transaction) ses.beginTransaction(); //all update and delete methods must happen within a transaction
		ses.merge(account);
		tran.commit();
		HibernateUtil.closeSession();
		return account;
    }
}
