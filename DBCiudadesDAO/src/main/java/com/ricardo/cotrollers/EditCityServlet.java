package com.ricardo.cotrollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.CiudadesDAO;
import com.ricardo.models.City;

@WebServlet("/editar")
public class EditCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		City unaCity=null;
		try {
			unaCity = CiudadesDAO.getInstance().getCity(request.getParameter("city"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("city", unaCity);
		request.getRequestDispatcher("editcity.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = request.getParameter("cid") != null ? Integer.parseInt(request.getParameter("cid")) : 0;
			String name = request.getParameter("nombre");
			String countryCode = request.getParameter("countrycode");
			String district = request.getParameter("district");
			int population = request.getParameter("population") != null
					? Integer.parseInt(request.getParameter("population"))
					: 0;

			if (id > 0) {
				City cityToUpdate = new City(id, name, countryCode, district, population);
				
				boolean isOk = CiudadesDAO.getInstance().updateCity(cityToUpdate);
			}

		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
