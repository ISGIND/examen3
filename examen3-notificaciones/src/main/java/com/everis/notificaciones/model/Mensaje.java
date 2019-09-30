package com.everis.notificaciones.model;


public class Mensaje {
	
	private String numero;
	private String mensaje;
	private String latitud;
	private String longitud;
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
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + "]";
	}
	
	
}
