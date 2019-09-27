package com.everis.pedidos.model;
// Generated 27/09/2019 12:58:19 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "producto", catalog = "examen3")
public class Producto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private Double precio;
	private String url;
	@JsonIgnore
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);

	public Producto() {
	}

	public Producto(int id) {
		this.id = id;
	}

	public Producto(int id, String nombre, Double precio, String url, Set<Pedido> pedidos) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.url = url;
		this.pedidos = pedidos;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "precio", precision = 22, scale = 0)
	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Column(name = "url", length = 45)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pedido_has_producto", catalog = "examen3", joinColumns = {
			@JoinColumn(name = "producto_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "pedido_id", nullable = false, updatable = false) })
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
