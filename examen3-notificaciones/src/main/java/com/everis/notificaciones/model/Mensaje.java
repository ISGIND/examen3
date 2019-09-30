package com.everis.notificaciones.model;

import java.math.BigDecimal;

public class Mensaje {
	
	private String numero;
	private String mensaje;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private String direccion;
	
public Mensaje() {
		// TODO Auto-generated constructor stub
	}
	//	public Mensaje(String numero, String mensaje) {
//		this.numero = numero;
//		this.mensaje = mensaje;
//	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public BigDecimal getLatitud() {
		return latitud;
	}
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}
	public BigDecimal getLongitud() {
		return longitud;
	}
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
