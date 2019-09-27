package com.everis.pedidos.response;

import java.math.BigDecimal;

import com.everis.pedidos.model.Pedido;

public class NotificacionResponse {
	private boolean successful;
	private String tipoMensaje; 
	private String message;
	private Pedido pedido;
	private BigDecimal port;	
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public BigDecimal getPort() {
		return port;
	}
	public void setPort(BigDecimal port) {
		this.port = port;
	}
	
	
}
