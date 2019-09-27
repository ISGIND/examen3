package com.everis.notificaciones.responses;

import com.everis.notificaciones.model.Pedido;

public class PedidoResponse {
	
	private boolean successful;
	private Pedido pedido;
	private String message;

	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
