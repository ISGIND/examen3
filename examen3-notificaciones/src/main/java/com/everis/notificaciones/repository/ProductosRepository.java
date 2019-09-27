package com.everis.notificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.notificaciones.model.Producto;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Integer>{

}
