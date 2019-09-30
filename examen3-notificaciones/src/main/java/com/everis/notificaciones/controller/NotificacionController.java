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
import com.everis.notificaciones.repository.ProductosRepository;
import com.everis.notificaciones.responses.NotificacionResponse;
import com.everis.notificaciones.responses.PedidoResponse;
import com.everis.notificaciones.responses.WhatsResponse;
import com.everis.notificaciones.service.CorreoService;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
	
	@Autowired
	CorreoService correo;
	
	@Autowired
	private WhatsAppProxy whatsAppProxy;
	
	@Autowired
	private Configuracion configuracion;
	@Autowired
	private ProductosRepository productosRepository;
	
	@PostMapping("/pedido")
	@ResponseBody
	public NotificacionResponse enviaConfirmacion(@RequestBody PedidoResponse pedidoResponse) {//(@RequestBody Pedido json) {
		NotificacionResponse response = new NotificacionResponse();
		Set<Producto> ids = pedidoResponse.getPedido().getProductos();
		String nombreproducto ="Productos: ";
		String tipo="";
		Producto productoBuscado = new Producto();
		
		for (Producto producto : ids) {
			productoBuscado=productosRepository.findById(producto.getId()).get();
			nombreproducto += productoBuscado.getNombre()+" ";
		}
		
		
		if(configuracion.getTiponotificacion().equals("dev") || configuracion.getTiponotificacion().equals("default")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto);
			String token = configuracion.getWhatzmeapitoken();
			WhatsResponse whatsresponse= whatsAppProxy.enviaMensaje(token, mensaje);
			boolean correo2 = correo.enviarCorreo(configuracion.getEmaildestino(), "Compra", mensaje.toString());
			if(whatsresponse.isExito() && correo2) {
				response.setSuccessful(true);
				response.setTipoMensaje("ambos");
			}
			
			
			
		}
		if(configuracion.getTiponotificacion().equals("qa")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto);
			String token = configuracion.getWhatzmeapitoken();
			boolean correo2=correo.enviarCorreo(configuracion.getEmaildestino(), "Compra", mensaje.toString());
			if(correo2) {
				response.setSuccessful(true);
				response.setTipoMensaje("email");
			}
		}
		if(configuracion.getTiponotificacion().equals("prod")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto);
			String token = configuracion.getWhatzmeapitoken();	
			WhatsResponse whatsresponse= whatsAppProxy.enviaMensaje(token, mensaje);
			if(whatsresponse.isExito()) {
				response.setSuccessful(true);
				response.setTipoMensaje("whats");
			}
		}
			
		return response;		
	}
	

}
