package com.everis.notificaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.notificaciones.model.Configuracion;
import com.everis.notificaciones.model.Mensaje;
import com.everis.notificaciones.model.Pedido;
import com.everis.notificaciones.proxy.WhatsAppProxy;
import com.everis.notificaciones.responses.NotificacionResponse;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
	
	@Autowired
	private WhatsAppProxy whatsAppProxy;
	
	@Autowired
	private Configuracion configuracion;
	
	@PostMapping("/pedido")
	@ResponseBody
	public NotificacionResponse enviaConfirmacion(@RequestBody Pedido pedido) {//(@RequestBody Pedido json) {
		NotificacionResponse response = new NotificacionResponse();
		int[] ids = null;
		Mensaje mensaje = new Mensaje();
		mensaje.setNumero(configuracion.getWhatsappdestino());
		String token = configuracion.getWhatzmeapitoken();
		//mensaje.setMensaje(Pedido.get);
		whatsAppProxy.enviaMensaje(token, mensaje);
		
		
		
		
		
		return null;
		
	}
	

}
