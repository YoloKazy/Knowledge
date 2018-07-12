package com.ricardo.cotrollers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.CountryDAO;
import com.ricardo.db.CountryDAOFactory;
import com.ricardo.db.CountryDAOMysql;
import com.ricardo.models.Country;

@WebServlet("/listapaises")
public class ListaPaisesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Country> listaPaises=null;
		
		try {
			
			CountryDAO cDao=CountryDAOFactory.getDAO("mongo");			
			listaPaises=cDao.getLista();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listapaises", listaPaises);
		
		request.getRequestDispatcher("listapaises.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
