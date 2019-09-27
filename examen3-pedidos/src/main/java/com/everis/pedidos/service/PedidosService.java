package com.everis.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.pedidos.model.Pedido;
import com.everis.pedidos.repository.PedidoRepository;

@Service
public class PedidosService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Pedido insertarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
}
