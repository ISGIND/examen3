package com.everis.notificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.notificaciones.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
