package com.everis.pedidos.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.everis.pedidos.model.Pedido;
import com.everis.pedidos.response.PedidoResponse;

@FeignClient(name="EXAMEN3-NOTIFICACIONES")
@RibbonClient(name = "EXAMEN3-PEDIDOS")
public interface PedidoServiceProxy {

	@PostMapping("/spring-cloud-rest/pedido/{pedido}}")
	public PedidoResponse pedidoResponse(@RequestBody Pedido json);
	
	
}
