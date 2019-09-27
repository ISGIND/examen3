package com.everis.notificaciones.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.notificaciones.model.Mensaje;
import com.everis.notificaciones.responses.WhatsResponse;



@FeignClient(name="whatzmeapi", url="https://whatzmeapi.com:10501/rest/api")
public interface WhatsAppProxy {
	
	@PostMapping("/enviar-mensaje?")
	public WhatsResponse enviaMensaje(@RequestParam(name="token") String token, @RequestBody Mensaje mensaje);
	
//	@PostMapping(url)
//	public WhatsResponse enviaMensaje(@RequestBody Mensaje mensaje);

}
