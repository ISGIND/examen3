package com.everis.notificaciones.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.notificaciones.model.Configuracion;
import com.everis.notificaciones.model.Mensaje;
import com.everis.notificaciones.model.Producto;
import com.everis.notificaciones.proxy.WhatsAppProxy;
import com.everis.notificaciones.repository.ProductosRepository;
import com.everis.notificaciones.responses.NotificacionResponse;
import com.everis.notificaciones.responses.PedidoResponse;
import com.everis.notificaciones.responses.WhatsResponse;
import com.everis.notificaciones.service.CorreoService;



@RestController
@RequestMapping("/prueba")
public class prueba {
	
	@Autowired
	CorreoService correo;
	
	
	@Autowired
	private WhatsAppProxy whatsAppProxy;
	
	@Autowired
	private Configuracion configuracion;
	@Autowired
	private ProductosRepository productosRepository;

	@GetMapping("/")
	public NotificacionResponse enviaConfirmacion() {//(@RequestBody Pedido json) {
		NotificacionResponse response = new NotificacionResponse();
		String nombreproducto ="Productos: ";
		String tipo="";
		Producto productoBuscado = new Producto();
		
		response.setSuccessful(false);
		
		if(configuracion.getTiponotificacion().equals("ambas")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto);
			String token = configuracion.getWhatzmeapitoken();
			WhatsResponse whatsresponse= whatsAppProxy.enviaMensaje(token, mensaje);
			WhatsResponse whatsresponse1 = whatsAppProxy.enviaUbicacion(token, mensaje);
			boolean correo2 = correo.enviarCorreo(configuracion.getEmaildestino(), "Compra", mensaje.toString());
			if(whatsresponse.isExito() && correo2 && whatsresponse1.isExito()) {
				response.setSuccessful(true);
				response.setTipoMensaje("ambos");
				return response;	
			}
			else {
				response.setSuccessful(false);
				return response;	
			}
			
			
		}
		if(configuracion.getTiponotificacion().equals("email")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto);
			String token = configuracion.getWhatzmeapitoken();
			boolean correo2=correo.enviarCorreo(configuracion.getEmaildestino(), "Compra", mensaje.toString());
			if(correo2) {
				response.setSuccessful(true);
				response.setTipoMensaje("email");
				return response;	
			}
			else {
				response.setSuccessful(false);
				return response;	
			}
		}
		if(configuracion.getTiponotificacion().equals("whatsapp")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto);
			String token = configuracion.getWhatzmeapitoken();	
			WhatsResponse whatsresponse= whatsAppProxy.enviaMensaje(token, mensaje);
			WhatsResponse whatsresponse1 = whatsAppProxy.enviaUbicacion(token, mensaje);
			if(whatsresponse.isExito() && whatsresponse1.isExito()) {
				response.setSuccessful(true);
				response.setTipoMensaje("whats");
				return response;	
			}
			else {
				response.setSuccessful(false);
				return response;	
			}
		}
		
			
		return response;		
	}
}
