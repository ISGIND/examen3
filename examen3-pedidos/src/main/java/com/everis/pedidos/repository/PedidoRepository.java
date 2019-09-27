package com.everis.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.pedidos.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer>{

}
