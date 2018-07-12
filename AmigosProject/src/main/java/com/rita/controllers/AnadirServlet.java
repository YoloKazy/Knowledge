package com.rita.controllers;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rita.db.DDBB;
import com.rita.models.Amigo;

/**
 * Servlet implementation class AnadirServlet
 */
@WebServlet("/anadir")
public class AnadirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreAmigo=request.getParameter("nombreAmigo");
		Amigo nuevoAmigo=DDBB.getInstance().AnadirAmigo(nombreAmigo);
		String respuesta ="";
/*		if(nuevoAmigo!=null) {
			respuesta="{\"idAmigo\":"+nuevoAmigo.getIdAmigo()+",\"nombre\":\""+nuevoAmigo.getNombre()+"\",\"puntuacion\":0}";
		}else {
			respuesta= "{\"unAmigo\":null}";
		}
*/
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);		
		StringWriter stringEmp = new StringWriter();

		objectMapper.writeValue(stringEmp, nuevoAmigo);
		respuesta =""+stringEmp+"";
		
		response.setContentType("application/json");
		response.getWriter().append(respuesta).flush();
	}

}
