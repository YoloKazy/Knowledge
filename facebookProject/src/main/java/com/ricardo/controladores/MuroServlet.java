package com.ricardo.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricardo.database.Database;
import com.ricardo.models.Articulo;
import com.ricardo.models.Comentario;

@WebServlet("/muro")
public class MuroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("email")!=null) {
			List<Articulo> articulos = Database.getInstance().getArticulos();
			request.setAttribute("articulos", articulos);
			request.setAttribute("location", "muro");
			request.getRequestDispatcher("muro.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ida = !request.getParameter("article").equals("") ? Integer.parseInt(request.getParameter("article")) : 0;
		Articulo articulo = Database.getInstance().getArticulo(ida);

		Comentario newComment = new Comentario(request.getParameter("autor"), request.getParameter("comentario"));

		if (articulo != null)
			articulo.addComentario(newComment);

		doGet(request, response);
	}

}
