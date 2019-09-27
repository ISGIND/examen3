package com.everis.notificaciones.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.notificaciones.model.Configuracion;
import com.everis.notificaciones.model.Mensaje;
import com.everis.notificaciones.model.Producto;
import com.everis.notificaciones.proxy.WhatsAppProxy;
import com.everis.notificaciones.responses.NotificacionResponse;
import com.everis.notificaciones.responses.PedidoResponse;
import com.everis.notificaciones.responses.WhatsResponse;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
	
	@Autowired
	private WhatsAppProxy whatsAppProxy;
	
	@Autowired
	private Configuracion configuracion;
	
	@PostMapping("/pedido")
	@ResponseBody
	public NotificacionResponse enviaConfirmacion(@RequestBody PedidoResponse pedidoResponse) {//(@RequestBody Pedido json) {
		NotificacionResponse response = new NotificacionResponse();
		Set<Producto> ids = pedidoResponse.getPedido().getProductos();
		String nombreproducto ="Productos: ";
		
		for (Producto producto : ids) {
			nombreproducto += producto.getNombre()+" ";
		}
		
		Mensaje mensaje = new Mensaje();
		mensaje.setNumero(configuracion.getWhatsappdestino());
		mensaje.setMensaje(nombreproducto);
		String token = configuracion.getWhatzmeapitoken();
		//mensaje.setMensaje(Pedido.get);
		WhatsResponse whatsresponse= whatsAppProxy.enviaMensaje(token, mensaje);
		
		return response;		
	}
	

}
