package com.ricardo.controladoras;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.modelos.Mensaje;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensaje unMensaje = new Mensaje("Yo", "Pedrita", "Hola tron!!");
		Mensaje unMensaje2 = new Mensaje("Pedrita", "Yo", "Hola tron!!");
		System.out.println(unMensaje);
		
		request.setAttribute("mensaje", unMensaje);
		request.setAttribute("mensaje2", unMensaje);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensaje newMessage= new Mensaje(request.getParameter("remitente"), 
				request.getParameter("receptor"), 
				request.getParameter("mensaje"));
		
		request.setAttribute("mensaje3", newMessage);
		doGet(request, response);
	}

}
