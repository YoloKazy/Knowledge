package com.rita.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rita.db.DDBB;
import com.rita.models.Amigo;

@WebServlet("/lista")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Amigo> listaAmigos= DDBB.getInstance().getAmigos();
		request.setAttribute("listaAmigos", listaAmigos);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int idAmigo=Integer.parseInt(request.getParameter("id"));
			
			boolean isOK=DDBB.getInstance().removeAmigos(idAmigo);
			response.setContentType("application/json");
			response.getWriter().append("{\"result\":"+isOK+"}").flush();

	}
}
