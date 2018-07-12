package com.ricardo.controladoras;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.modelos.Usuario;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repassword");
		String edad_str = request.getParameter("edad");
		int edad = edad_str != null && !edad_str.equals("") ? Integer.parseInt(edad_str) : 0;
		String sexo_str = request.getParameter("sexo");
		int sexo = sexo_str != null && !sexo_str.equals("") ? Integer.parseInt(sexo_str) : -1;

		Usuario newU = new Usuario(nombre, email, pass, edad, sexo);
		Hashtable errors = newU.validar();
		boolean hayError = (boolean) errors.get("hayError");

		if (newU.getPassword() == null || newU.getPassword().equals("") || repass == null || repass.equals("") || (!repass.equals(newU.getPassword()))) {
			errors.put("pass", "Password y repassword. Deben Coincidir");			
		}
		
		//Decidimos si hay error o no
		if (hayError) {
			request.setAttribute("errors", errors);
			request.setAttribute("usuario", newU);
			doGet(request, response);
		} else {
			//si está bien enviamos mail y redigimos a login
			response.sendRedirect("login");
		}

	}

}
