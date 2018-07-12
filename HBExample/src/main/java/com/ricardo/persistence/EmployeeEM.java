package com.ricardo.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ricardo.models.Employee;

public class EmployeeEM extends EntityManager {

	private static EmployeeEM instance = null;

	public static final EmployeeEM getInstance() {
		if (instance == null)
			instance = new EmployeeEM();
		return instance;
	}

	protected EmployeeEM() {
		super();
	}

	public List<Employee> getLista() {
		List<Employee> employees = null;
		try {
			/* Hibernate */

			Session session = factory.openSession();

			Transaction t = session.beginTransaction();
			employees = session.createQuery("FROM Employee", Employee.class).getResultList();

			t.commit();
			session.close();
			/* Hibernate */
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	public boolean save(Employee emp) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		session.save(emp);

		t.commit();
		session.close();

		return true;

	}

}
