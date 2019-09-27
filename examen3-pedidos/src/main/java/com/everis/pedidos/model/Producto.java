package com.everis.pedidos.model;
// Generated 27/09/2019 12:36:02 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "producto", catalog = "examen3")
public class Producto implements java.io.Serializable {

	private int idproducto;
	private Pedidos pedidos;
	private String nombre;
	private Double precio;
	private String url;

	public Producto() {
	}

	public Producto(int idproducto, Pedidos pedidos) {
		this.idproducto = idproducto;
		this.pedidos = pedidos;
	}

	public Producto(int idproducto, Pedidos pedidos, String nombre, Double precio, String url) {
		this.idproducto = idproducto;
		this.pedidos = pedidos;
		this.nombre = nombre;
		this.precio = precio;
		this.url = url;
	}

	@Id

	@Column(name = "idproducto", unique = true, nullable = false)
	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedidos_id", nullable = false)
	public Pedidos getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
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

}
