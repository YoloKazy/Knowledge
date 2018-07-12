package com.ricardo.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.DDBB;

@WebServlet("/puntuacion")
public class PuntuacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAmigo = Integer.parseInt(request.getParameter("id"));
		int punt = Integer.parseInt(request.getParameter("puntuacion"));
		
		System.out.println("Recibido:"+idAmigo+":"+punt);
		
		boolean isOk=DDBB.getInstance().updatePuntuacion(idAmigo,punt);
				
		response.setContentType("application/json");
		response.getWriter().append("{\"result\":"+isOk+"}").flush();
	}

}
