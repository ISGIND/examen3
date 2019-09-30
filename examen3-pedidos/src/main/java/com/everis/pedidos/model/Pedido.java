package com.everis.pedidos.model;
// Generated 27/09/2019 12:58:19 PM by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pedido generated by hbm2java
 */
@Entity
@Table(name = "pedido", catalog = "examen3")
public class Pedido implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Cliente cliente;
	private Date fechahoraregistro;
	private Date fechahoraentrega;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Pedido() {
	}

	public Pedido(int id, Cliente cliente) {
		this.id = id;
		this.cliente = cliente;
	}

	public Pedido(int id, Cliente cliente, Date fechahoraregistro, Date fechahoraentrega, Set<Producto> productos) {
		this.id = id;
		this.cliente = cliente;
		this.fechahoraregistro = fechahoraregistro;
		this.fechahoraentrega = fechahoraentrega;
		this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_idcliente", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechahoraregistro", length = 19)
	public Date getFechahoraregistro() {
		return this.fechahoraregistro;
	}

	public void setFechahoraregistro(Date fechahoraregistro) {
		this.fechahoraregistro = fechahoraregistro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechahoraentrega", length = 19)
	public Date getFechahoraentrega() {
		return this.fechahoraentrega;
	}

	public void setFechahoraentrega(Date fechahoraentrega) {
		this.fechahoraentrega = fechahoraentrega;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pedido_has_producto", catalog = "examen3", joinColumns = {
			@JoinColumn(name = "pedido_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "producto_id", nullable = false, updatable = false) })
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
