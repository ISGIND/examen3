package com.everis.pedidos.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoController extends JpaRepository<Producto, Integer> {

}
