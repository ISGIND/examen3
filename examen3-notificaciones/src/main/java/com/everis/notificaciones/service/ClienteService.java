package com.everis.notificaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.notificaciones.model.Cliente;
import com.everis.notificaciones.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarCliente(int id) {
		return clienteRepository.findById(id).get();
	}

}
