package com.everis.notificaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.notificaciones.service.CorreoService;



@RestController
@RequestMapping("/prueba")
public class prueba {
	
	@Autowired
	CorreoService correo;

	@GetMapping("/")
	public void pruebaCorreo() {
		correo.enviarCorreo("raulsan8@gmail.com", "Academia-Everis-Examen1", "Ya estuvo el examen profe XD");
	}
}
