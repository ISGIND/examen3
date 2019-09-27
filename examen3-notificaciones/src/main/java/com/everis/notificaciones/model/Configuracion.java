package com.everis.notificaciones.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config")
public class Configuracion {
	
	private String tiponotificacion;
	private String whatzmeapitoken;
	private String whatsappdestino;
	private String emaildestino;
	
	public String getTiponotificacion() {
		return tiponotificacion;
	}
	public void setTiponotificacion(String tiponotificacion) {
		this.tiponotificacion = tiponotificacion;
	}
	public String getWhatzmeapitoken() {
		return whatzmeapitoken;
	}
	public void setWhatzmeapitoken(String whatzmeapitoken) {
		this.whatzmeapitoken = whatzmeapitoken;
	}
	public String getWhatsappdestino() {
		return whatsappdestino;
	}
	public void setWhatsappdestino(String whatsappdestino) {
		this.whatsappdestino = whatsappdestino;
	}
	public String getEmaildestino() {
		return emaildestino;
	}
	public void setEmaildestino(String emaildestino) {
		this.emaildestino = emaildestino;
	}
	
	

}
