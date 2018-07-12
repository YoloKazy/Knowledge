package com.ricardo.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricardo.database.Database;
import com.ricardo.models.Articulo;
import com.ricardo.models.Usuario;

/**
 * Servlet implementation class NuevoServlet
 */
@WebServlet("/nuevo")
public class NuevoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("email") != null) {
			request.setAttribute("location", "nuevo");
			request.getRequestDispatcher("nuevo.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("email") != null) {
			String texto = request.getParameter("texto");

			if (texto.equals("")) {
				request.setAttribute("error", "Completa el campo!!");
				doGet(request, response);
			} else {
				Database ddbb = Database.getInstance();
				Usuario elUser = Database.getUsuarioByEmail((String) session.getAttribute("email"));

				Articulo newArt = new Articulo(0, elUser.getNombre(), texto);
				
				Database.addArticle(newArt);
				
				response.sendRedirect("muro");
			}

		} else {
			response.sendRedirect("login");
		}

	}

}
