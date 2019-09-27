package com.everis.pedidos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.pedidos.model.Pedido;
import com.everis.pedidos.response.PedidoResponse;
import com.everis.pedidos.service.PedidosService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping()

	@PostMapping()
	@ResponseBody
	public PedidoResponse nuevoPedido(@RequestBody Pedido pedido) {
		PedidoResponse pedidoResponse = new PedidoResponse();
		try {
			pedidoResponse.setPedido(pedidoService.insertarPedido(pedido));
			pedidoResponse.setSuccessful(true);
			pedidoResponse.setMessage("chingon");
			
		} catch (Exception e) {
			// TODO: handle exception
			pedidoResponse.setSuccessful(false);
			pedidoResponse.setMessage(e.getMessage());
		}
		
		
		//NO ENVIAR PEDIDO; ENVIAR NOTIFICACION RESPONSE
		return pedidoResponse;
	}
	
}
