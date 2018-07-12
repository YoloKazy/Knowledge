package com.ricardo.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.DDBB;


@WebServlet("/lista")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("amigos", DDBB.getInstance().getAmigos());		
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAmigo = Integer.parseInt(request.getParameter("id"));
		
		boolean isOk=DDBB.getInstance().deleteAmigos(idAmigo);
				
		response.setContentType("application/json");
		response.getWriter().append("{\"result\":"+isOk+"}").flush();
	}
	
	
}









