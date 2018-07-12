package com.ricardo.cotrollers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.CiudadesDAO;

@WebServlet("/borrarciudad")
public class BorrarCiudadServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean isOk=false;
		String code="";
		try {
			int cid=Integer.parseInt(request.getParameter("cid"));
			code=request.getParameter("code");
			
			isOk=CiudadesDAO.getInstance().deleteCity(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!isOk) request.setAttribute("error", "Ha habido un error");
		
		request.getRequestDispatcher("listaciudades?country="+code).forward(request, response);
		//response.sendRedirect("listaciudades?country="+code );
	}
}
