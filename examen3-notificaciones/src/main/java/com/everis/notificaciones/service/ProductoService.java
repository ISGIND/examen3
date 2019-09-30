package com.everis.notificaciones.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.notificaciones.model.Producto;
import com.everis.notificaciones.repository.ProductosRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductosRepository productoRepository;
	
	public Producto buscarProducto(int id){
		return productoRepository.findById(id).get();
	}
}
