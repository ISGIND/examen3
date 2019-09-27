package com.everis.notificaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.everis.notificaciones.proxy.WhatsAppProxy;

@RestController
public class NotificacionController {
	
	@Autowired
	WhatsAppProxy whatsAppProxy;

}
