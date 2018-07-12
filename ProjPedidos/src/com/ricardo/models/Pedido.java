package com.ricardo.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int id;
	private Cliente cliente;
	private List<Item> items;
	
	public Pedido(int id, Cliente cliente) {
		items=new ArrayList<>();
		this.id = id;
		this.cliente = cliente;
	}

	public boolean addItem(Item aItem) {
		return this.items.add(aItem);
	}

	
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void showItems() {
		System.out.println("\nELEMENTOS DEL PEDIDO:");
		for (Item aItem : this.items) {
			System.out.println(aItem.showDetails());
		}
	}
	
	
}
