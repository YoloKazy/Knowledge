package com.ricardo.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ricardo.models.Order;

public class PedidosEM extends EntityManager {
	private static PedidosEM instance = null;

	public static final PedidosEM getInstance() {
		if (instance == null)
			instance = new PedidosEM();
		return instance;
	}

	private PedidosEM() {
		super();
	}

	public List<Order> getLista() throws Exception{
		List<Order> pedidos = null;

		Session session = factory.openSession();
		pedidos = session.createQuery("FROM Order", Order.class).getResultList();
		session.close();

		return pedidos;
	}

	public int inserta(Order nuevoPedido) throws Exception{
		int newId = 0;

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		newId = (Integer) session.save(nuevoPedido);

		t.commit();
		session.close();

		return newId;
	}
	
	public boolean actualizar(Order pedidoAActualizar) throws Exception{
		boolean isOk = false;

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		session.update(pedidoAActualizar);

		t.commit();
		session.close();
		
		isOk = true;

		return isOk;
	}

	public List<Order> getListaFromUser(int userId) {
		List<Order> pedidos = null;

		Session session = factory.openSession();
		pedidos = session.createQuery("FROM Order WHERE customer=:cid", Order.class).setParameter("cid",userId).getResultList();
		session.close();

		return pedidos;
	}
}
