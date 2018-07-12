package com.ricardo.persistence;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ricardo.models.Employee;

public class EmployeeEMTest extends com.ricardo.persistence.Test {
	private static Logger logger = Logger.getLogger("EmployeeEMTest");

	@BeforeClass
	public static void setUpClass() {
		setUpContext();
	}

	@Test
	public void testListaEmployees() {

		logger.log(Level.INFO, "Entrando al test...");

		try {
			EmployeeEM emplEM = EmployeeEM.getInstance();
			List<Employee> listaEmployees= emplEM.getLista();
			
			logger.log(Level.INFO, "listaEmployees..." + listaEmployees);
			assertTrue(listaEmployees != null && !listaEmployees.isEmpty());

		} catch (Exception ex) {			
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
			fail();
		}

		logger.log(Level.INFO, "Fin de test...");
	}
}
