package com.maxxpotential.repositories;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.maxxpotential.models.User;
import com.maxxpotential.utils.HibernateUtil;

public class UserDAO {
	
	//Hibernate DAO methods incorporate the sessions objects methods to create/manipulate data (SESSION METHODS)
	
	//HQL is best used if you're SELECTing ALL from the DB. If you want to SELECT BY, you should use sessions methods (below)
	public List<User> getAllUsers(){  //This will use SQL SELECT functionality
		
		//open a Session object to establish connection to database
		Session ses = HibernateUtil.getSession();
		
		//SELECT all users, with HQL instead of session methods, and put the values into a List (this will be one line)
		List<User> userList = ses.createQuery("FROM User").list();
		
		//close the session to prevent memory leaks
		HibernateUtil.closeSession();
		
		//return the List of User
		return userList; 
	}
	
	//Session methods are best used when you're SELECTing by the primary key, 
		//because get() and load() both expect a serializable (which our primary key is)
	public User getUserById(int id) {
		
		//open a Session object
		Session ses = HibernateUtil.getSession();
		
		//SELECT all users by ID (which should just be one user)
		User userbyid = ses.get(User.class, id);
		
		//close the session
		HibernateUtil.closeSession();
		
		//return the List of users
		return userbyid;
	}
	
	public List<User> getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("FROM User u WHERE u.username = ?0");
		q.setParameter(0,username);
		List<User> user = q.getResultList();
		HibernateUtil.closeSession();
		return user;
	}
		
	public void insertUser(User user) {
		
		//open a Session object to establish a connection to the DB
		Session ses = HibernateUtil.getSession();
		
		//insert a user into the DB
		ses.save(user);
		
		//close the Session object to prevent memory leaks
		HibernateUtil.closeSession();
	}
	
	//Using session method to update
	public User updateUser(User user) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction(); //all update and delete methods must happen within a transaction
		ses.merge(user);
		tran.commit();
		
		//close the transaction and session
		HibernateUtil.closeSession();
	
		return user;
	}

	public User deleteUser(int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		User user = new User();
		user.setId(id);
		ses.delete(user);
		tran.commit();
		HibernateUtil.closeSession();
		return user;
	}
}
