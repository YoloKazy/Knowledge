package com.ricardo.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricardo.database.Database;
import com.ricardo.models.Usuario;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("email")!=null) {
			response.sendRedirect("muro");
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");		
		Usuario unUsuarioEncontrado = Database.getInstance().getUsuario(email, pass);
				
		if(unUsuarioEncontrado!=null) {
			 HttpSession session = request.getSession();
			 session.setAttribute("email", unUsuarioEncontrado.getEmail());
			
			response.sendRedirect("muro");
		}else {
			request.setAttribute("error", "Los datos son incorrectos!!!");
			this.doGet(request, response);
		}
		
		
	}

}
