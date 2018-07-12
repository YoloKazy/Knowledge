package com.ricardo.controladores;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricardo.database.Database;
import com.ricardo.models.Articulo;
import com.ricardo.models.Usuario;

/**
 * Servlet implementation class PerfilServlet
 */
@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("email") != null) {
			Usuario elUser = Database.getInstance().getUsuarioByEmail((String) session.getAttribute("email"));
			
			request.setAttribute("usuario", elUser);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("email") != null) {
			
			String nombre = request.getParameter("nombre");
			String email = (String)session.getAttribute("email");
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
				
			} else {
				Database ddbb = Database.getInstance();
				ddbb.updateUsuario(newU);
			}
			
			doGet(request, response);
						
		} else {
			response.sendRedirect("login");
		}
	}

}
