package com.everis.notificaciones.model;
// Generated 27/09/2019 12:58:19 PM by Hibernate Tools 5.2.12.Final



import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Cliente generated by hbm2java
 */

public class Cliente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String latitud;
	private String longitud;
	@JsonIgnore
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);

	public Cliente() {
	}

	public Cliente(int id) {
		this.id = id;
	}

	public Cliente(int id, String nombre, String latitud, String longitud, Set<Pedido> pedidos) {
		this.id = id;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.pedidos = pedidos;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
