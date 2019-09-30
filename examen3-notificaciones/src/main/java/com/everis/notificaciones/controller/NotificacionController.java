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
import com.everis.notificaciones.service.ClienteService;
import com.everis.notificaciones.service.CorreoService;
import com.everis.notificaciones.service.ProductoService;

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
	private ProductoService productoService;
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping("/pedido")
	@ResponseBody
	public NotificacionResponse enviaConfirmacion(@RequestBody PedidoResponse pedidoResponse) {//(@RequestBody Pedido json) {
		NotificacionResponse response = new NotificacionResponse();
		Set<Producto> ids = pedidoResponse.getPedido().getProductos();
		String latitud = clienteService.buscarCliente(pedidoResponse.getPedido().getCliente().getId()).getLatitud();
		String longitud = clienteService.buscarCliente(pedidoResponse.getPedido().getCliente().getId()).getLongitud();
		String nombreproducto ="Productos: ";
		String tipo="";
		Producto productoBuscado = new Producto();
		
		for (Producto producto : ids) {
			productoBuscado=productoService.buscarProducto(producto.getId());
			nombreproducto += productoBuscado.getNombre()+" ";
		}
		
		response.setSuccessful(false);
		
		if(configuracion.getTiponotificacion().equals("ambas")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto.toString());
			String token = configuracion.getWhatzmeapitoken();
			mensaje.setDireccion("Esta direccion");
			mensaje.setLatitud(latitud);
			mensaje.setLongitud(longitud);
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
				response.setTipoMensaje("Imposible enviar todas las notificaciones");
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
				response.setTipoMensaje("Imposible enviar email");
				return response;	
			}
		}
		if(configuracion.getTiponotificacion().equals("whatsapp")){
			Mensaje mensaje = new Mensaje();			
			mensaje.setNumero(configuracion.getWhatsappdestino());
			mensaje.setMensaje(nombreproducto);
			String token = configuracion.getWhatzmeapitoken();
			mensaje.setDireccion("Esta direccion");
			mensaje.setLatitud(latitud);
			mensaje.setLongitud(longitud);
			WhatsResponse whatsresponse= whatsAppProxy.enviaMensaje(token, mensaje);
			WhatsResponse whatsresponse1 = whatsAppProxy.enviaUbicacion(token, mensaje);
			if(whatsresponse.isExito() && whatsresponse1.isExito()) {
				response.setSuccessful(true);
				response.setTipoMensaje("whats");
				return response;	
			}
			else {
				response.setSuccessful(false);
				response.setTipoMensaje("Imposible enviar whats");
				return response;	
			}
		}
		
			
		return response;		
	}
	

}
