package com.rita.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rita.db.DDBB;

@WebServlet("/puntuacion")
public class PuntuacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAmigo=Integer.parseInt(request.getParameter("id"));
		int idValorar=Integer.parseInt(request.getParameter("idValor"));		
		boolean isOK=DDBB.getInstance().updateAmigos(idAmigo, idValorar);
		
		//System.out.println(" puntuacion :::  "+DDBB.getInstance().getAmigo(idAmigo).getPuntuacion());
		
		
		response.setContentType("application/json");
		response.getWriter().append("{\"result\":"+isOK+"}").flush();
		
	}

}
