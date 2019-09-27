package com.everis.pedidos.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.everis.pedidos.response.PedidoResponse;

@FeignClient(name="EXAMEN3-PEDIDOS")
@RibbonClient(name = "EXAMEN3-PEDIDOS")
public interface PedidoServiceProxy {

	@GetMapping("/consultarInventario/producto/{id}")
	public PedidoResponse retrieveInventario(@PathVariable int id);
	
	//  /rest/api/enviar-mensaje?877be9b47ac39dcbdac80d4fff18e554352abc13
	@PostMapping("/decrementar/producto/{id}/cantidad/{cantidad}")
	public PedidoResponse retrieveDecrementar(@PathVariable int id, @PathVariable int cantidad);
	
}
