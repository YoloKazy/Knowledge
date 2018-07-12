package com.ricardo.cotrollers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.CiudadesDAO;
import com.ricardo.db.CountryDAOMysql;
import com.ricardo.models.City;
import com.ricardo.models.Country;

@WebServlet("/listaciudades")
public class CiudadesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String countryFiltro = request.getParameter("country")!=null?request.getParameter("country"):"";
		countryFiltro = countryFiltro.length() > 3 ? "" : countryFiltro;
		System.out.println("country:" + countryFiltro);

		request.setAttribute("countryCode", countryFiltro);
		
		String countryCode = request.getAttribute("countryCode") != null ? (String) request.getAttribute("countryCode")
				: "";
		
		List<City> resultCity = null;
		List<Country> resultCountry=null;
		
		try {
			resultCity = CiudadesDAO.getInstance().getLista(countryCode);
			resultCountry = CountryDAOMysql.getInstance().getLista();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listaciudades", resultCity);
		request.setAttribute("listapaises", resultCountry);
		request.getRequestDispatcher("listaciudades.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		doGet(request, response);
	}

}
