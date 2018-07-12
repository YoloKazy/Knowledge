package com.ricardo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ricardo.models.Address;
import com.ricardo.models.Employee;
import com.ricardo.models.Role;
import com.ricardo.models.Unit;
import com.ricardo.persistence.EmployeeEM;

@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result= "No OK";
		
		try {
			
			Employee nuevoEmp= new Employee();
			nuevoEmp.setFirstName("Juan");
			nuevoEmp.setLastName("Perez");
			
			List<Role> roles=new ArrayList<Role>();
			roles.add(new Role("Marketing","pica código"));			
			
			nuevoEmp.setRoles(roles);
			
			Unit unaU=new Unit();
			unaU.setName("Marketing");
			unaU.setBudget(1000000);
			
			Address ad=new Address();
			ad.setCalle("Plaza Cat");
			ad.setNum("1C");
			
			unaU.setAddress(ad);
			
			/* Hibernate*/
			/*Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction t = session.beginTransaction();
			session.save(nuevoEmp);
			session.save(unaU);
			t.commit();

			session.close();*/
			/* Hibernate*/
			
			EmployeeEM.getInstance().save(nuevoEmp);
			
			result= "OK";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Added: ").append(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
