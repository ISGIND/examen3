package com.everis.pedidos.response;

import com.everis.pedidos.model.Pedido;

public class PedidoResponse {
	
	private boolean successful;
	private Pedido pedido;

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

	
}
