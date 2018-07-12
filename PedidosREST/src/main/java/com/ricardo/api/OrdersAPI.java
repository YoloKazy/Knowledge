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

import com.ricardo.models.Order;
import com.ricardo.models.StatusMessage;
import com.ricardo.persistence.PedidosEM;

@Path("/orders")
public class OrdersAPI extends JSONService {

	private static Logger logger = Logger.getLogger("Orders");

	public static List<Order> pedidos;

	static {
		pedidos = new ArrayList<Order>();
		pedidos.add(new Order(1, "Camara", 223.67));
		pedidos.add(new Order(2, "Balón", 3.67));
		pedidos.add(new Order(3, "Capa", 4.67));
	}

	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getPedidos(@HeaderParam("token") String token) {
		int userId = this.getUserIdFromToken(token);

		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {

			logger.info("Estoy enviando lista pedidos ...");
			try {
				return Response.status(202).entity(PedidosEM.getInstance().getListaFromUser(userId)).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(500).entity("Ha habido un error al pedir los pedidos").build();
			}
		}
	}

	@Path("/{idpedido}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getPedido(@PathParam(value = "idpedido") int idp) {

		Order unPedido = null;

		for (Order order : pedidos) {
			if (order.getId() == idp) {
				unPedido = order;
				break;
			}
		}

		if (unPedido != null)
			return Response.status(202).entity(unPedido).build();
		else
			return Response.status(404).entity("El objeto no existe").build();
	}

	@Path("/{idpedido}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public boolean deletePedido(@PathParam(value = "idpedido") int idp) {

		for (Order order : pedidos) {
			if (order.getId() == idp) {
				pedidos.remove(order);
				break;
			}
		}

		return true;
	}

	@Path("")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrder(@HeaderParam("token") String token, Order nuevoPedido) {
		int userId = this.getUserIdFromToken(token);

		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			try {
				nuevoPedido.setCustomer(userId);
				return Response.status(202).entity(PedidosEM.getInstance().inserta(nuevoPedido)).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al guardar el pedido").build();
			}
		}

	}

	@Path("/{idpedido}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response actualizarPedido(@HeaderParam("token") String token, @PathParam(value = "idpedido") int idP,
			Order pedidoAActualizar) {
		int userId = this.getUserIdFromToken(token);
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {

			boolean isOk = false;

			if (pedidoAActualizar.getId() == idP) {
				try {
					isOk = PedidosEM.getInstance().actualizar(pedidoAActualizar);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return Response.status(202).entity(isOk).build();
			} else {
				return Response.status(Status.FORBIDDEN.getStatusCode()).entity("Error").build();
			}
		}

	}

}
