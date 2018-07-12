package com.ricardo.controladoras;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.modelos.Usuario;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario unUsuarioSimulado = new Usuario("Ricardo", "r@r.es", "xxx",23,1);
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		System.out.println("*****Estoy en el post:"+email+"::"+pass);
		
		if(unUsuarioSimulado.getEmail().equals(email) && unUsuarioSimulado.getPassword().equals(pass)) {
			System.out.println("Pasar a dashboard");
			response.sendRedirect("dashboard");
		}else {
			System.out.println("Mostrar mensaje de error en form ");
			
			request.setAttribute("error", "Los datos son incorrectos!!!");
			this.doGet(request, response);
		}
		
		
	}

}
