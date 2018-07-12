package com.ricardo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ricardo.models.Customer;
import com.ricardo.models.Order;
import com.ricardo.models.StatusMessage;
import com.ricardo.persistence.CustomerEM;
import com.ricardo.persistence.PedidosEM;

@Path("/customers")
public class CustomersAPI extends JSONService{

	private static Logger logger = Logger.getLogger("Customers");

	public static List<Customer> usuarios;

	static {
		usuarios = new ArrayList<Customer>();
		usuarios.add(new Customer(1, "Juan", "j@j.com"));
		usuarios.add(new Customer(2, "Nuria", "n@n.com"));
	}

	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Customer> getUsuarios() {
		logger.info("Estoy enviando lista usuarios ...");
		return usuarios;
	}

	@Path("")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int addUsuario(Customer nuevoUsuario) {
		int nuevoId = (int) System.currentTimeMillis();
		nuevoUsuario.setId(nuevoId);
		usuarios.add(nuevoUsuario);
		return nuevoId;
	}

	@Path("/{idusuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Customer getUsuario(@PathParam(value = "idusuario") int idp) {

		Customer unUsuario = null;

		for (Customer cadaUsuario : usuarios) {
			if (cadaUsuario.getId() == idp) {
				unUsuario = cadaUsuario;
				break;
			}
		}

		return unUsuario;
	}

	@Path("/{idusuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deleteUsuario(@HeaderParam("token") String token, @PathParam(value = "idusuario") int idc) {

		int userId = this.getUserIdFromToken(token);
		
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			boolean isOk = false;
			try {
				Customer cToDelete = new Customer();
				cToDelete.setId(idc);
				isOk = CustomerEM.getInstance().deleteCustomer(cToDelete);
				return Response.status(Status.OK.getStatusCode()).entity(isOk).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al guardar el pedido").build();
			}
		}
		
	}

	@Path("/{idusuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public boolean actualizarUsuario(@PathParam(value = "idusuario") int idP, Customer userAActualizar) {
		boolean isOk = false;

		if (userAActualizar.getId() == idP) {

			for (Customer cadaUsuario : usuarios) {
				if (cadaUsuario.getId() == idP) {
					usuarios.remove(cadaUsuario);
					usuarios.add(userAActualizar);
					isOk = true;
					break;
				}
			}

		}

		return isOk;
	}

}
