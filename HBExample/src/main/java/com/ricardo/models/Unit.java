package com.ricardo.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="unidad")
public class Unit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="presupuesto")
	private double budget;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="direccion")
	private Address address;
	
	public Unit() {
		
	}
	
	public Unit(int uid, String name, double budget) {		
		this.uid = uid;
		this.name = name;
		this.budget = budget;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
