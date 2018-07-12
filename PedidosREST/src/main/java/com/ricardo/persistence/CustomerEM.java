package com.ricardo.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ricardo.models.Customer;
import com.ricardo.models.Order;

public class CustomerEM extends EntityManager {
	private static CustomerEM instance = null;

	public static final CustomerEM getInstance() {
		if (instance == null)
			instance = new CustomerEM();
		return instance;
	}

	private CustomerEM() {
		super();
	}

	public Customer getCustomerByEmailAndPass(String email, String pass) throws Exception{
		Customer usuario = null;

		Session session = factory.openSession();
		usuario = session.createQuery("FROM Customer WHERE email=:email AND password=:pass", Customer.class).setParameter("email", email).setParameter("pass", pass).getSingleResult();
		session.close();

		return usuario;
	}
	
	public boolean deleteCustomer(int cid) throws Exception{
		boolean isOk = false;

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Customer ctodelte= session.load(Customer.class, cid);
		session.delete(ctodelte);

		t.commit();
		session.close();
		
		isOk = true;

		return isOk;
	}
	
	public boolean deleteCustomer(Customer aCustomer) throws Exception{
		boolean isOk = false;

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		session.delete(aCustomer);

		t.commit();
		session.close();
		
		isOk = true;

		return isOk;
	}


}
