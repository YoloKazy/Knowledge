package com.ricardo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	
	@Column(name="nombre")
	private String name; 
	
	@Column(name="descripcion")
	private String description;
	
		
	public Role() {
		super();
	}

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Role(int rid, String name, String description) {
		super();
		this.rid = rid;
		this.name = name;
		this.description = description;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		

}
