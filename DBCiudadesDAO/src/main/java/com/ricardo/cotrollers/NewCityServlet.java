package com.ricardo.cotrollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.CiudadesDAO;
import com.ricardo.models.City;
import com.ricardo.models.Country;


@WebServlet("/newcity")
public class NewCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("newcity.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("nombre");
		String district = request.getParameter("district");
		int population = request.getParameter("population") != null
				? Integer.parseInt(request.getParameter("population"))
				: 0;
		
		City cityToAdd = new City(0, name, district, population);
				
		String countryCode = request.getParameter("countrycode");
		String countryName = request.getParameter("countryname");
								
		Country countryToAdd=new Country(countryCode, countryName);
		cityToAdd.setCountry(countryToAdd);
		
		boolean isOk=false;
		
		try {
			int newId = CiudadesDAO.getInstance().addCityAndCountry(cityToAdd);
			isOk=newId>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();					
		}
		
		//Verifico si hay error o no
		if(isOk) {
			response.sendRedirect("listaciudades");
		}else {
			request.setAttribute("error", "Verifica los campos");
			request.setAttribute("city", cityToAdd);			
			doGet(request, response);
		}
		
	}

}
