package com.everis.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.pedidos.model.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Integer> {

}
