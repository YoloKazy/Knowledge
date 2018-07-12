package com.ricardo.cotrollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.db.HabitacionDAO;
import com.ricardo.db.ReservaDAO;
import com.ricardo.db.UsuarioDAO;
import com.ricardo.models.Habitacion;
import com.ricardo.models.Reserva;
import com.ricardo.models.Usuario;

@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int hid = Integer.parseInt(request.getParameter("hid"));
			Habitacion habitacion = HabitacionDAO.getInstance().getHabitacion(hid);
			request.setAttribute("habitacion", habitacion);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("reserva.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int hid = Integer.parseInt(request.getParameter("hid"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			//double ppd = Double.parseDouble(request.getParameter("ppd"));
			int dias = Integer.parseInt(request.getParameter("dias"));
			
			Usuario usuario = UsuarioDAO.getInstance().getUsuario(uid);
			Habitacion habitacion = HabitacionDAO.getInstance().getHabitacion(hid);
			
			ReservaDAO.getInstance().add(new Reserva(0, usuario, habitacion, 1, dias, dias*habitacion.getPrecioDia()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
