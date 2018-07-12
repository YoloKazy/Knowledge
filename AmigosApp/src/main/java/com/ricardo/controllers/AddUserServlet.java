package com.ricardo.controllers;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ricardo.db.DDBB;
import com.ricardo.models.Amigo;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre= request.getParameter("nombre");
		Amigo newA = DDBB.getInstance().addAmigo( new Amigo(0, nombre) );
						
		String respuesta="";
		
		/*if(newA!=null) {
			respuesta ="{\"amigo\":{\"id\":"+newA.getId()+",\"name\":\""+newA.getName()+"\",\"puntuacion\":"+newA.getPuntuacion()+"}}";
		}else {			
			respuesta ="{\"amigo\":null}";
		}*/
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);		
		StringWriter stringEmp = new StringWriter();
		objectMapper.writeValue(stringEmp, newA);
		respuesta ="{\"amigo\":"+stringEmp+"}";
		
		response.setContentType("application/json");
		response.getWriter().append(respuesta).flush();
	}

}
