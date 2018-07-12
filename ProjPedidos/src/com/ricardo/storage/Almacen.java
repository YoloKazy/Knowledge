package com.ricardo.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ricardo.models.Item;

public class Almacen {
	private Map<Integer, Item> almacenItems = new HashMap<Integer, Item>();
	
	public Almacen(){
		this.almacenItems.put(new Integer(1),new Item(1, "libro", 18) );
		this.almacenItems.put(new Integer(2),new Item(2, "utencillo", 5) );
		this.almacenItems.put(new Integer(3),new Item(3, "cutter", 5) );
		this.almacenItems.put(new Integer(4),new Item(4, "sarten", 35) );
		this.almacenItems.put(new Integer(5),new Item(5, "frigo", 450) );
		
	}
	
	public void showItems() {
		System.out.println("\nELEMENTOS DEL ALMACEN:");
		for(Entry<Integer, Item> m : this.almacenItems.entrySet()){
			System.out.println(m.getKey()+" "+m.getValue().showDetails());
		}
	}
	
	public Item getItem(int id) {
		return this.almacenItems.get(new Integer(id));
	}
	
	public boolean sustraerItem(int id) {
		return this.almacenItems.remove(new Integer(id))!=null;
	}
}
