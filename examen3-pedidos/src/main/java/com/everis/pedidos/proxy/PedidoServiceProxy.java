package com.everis.pedidos.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.everis.pedidos.response.NotificacionResponse;
import com.everis.pedidos.response.PedidoResponse;

@FeignClient(name="EXAMEN3")
@RibbonClient(name = "EXAMEN3")
public interface PedidoServiceProxy {

	@PostMapping("notificacion/pedido")
	public NotificacionResponse enviaConfirmacion(@RequestBody PedidoResponse pedido);

}
