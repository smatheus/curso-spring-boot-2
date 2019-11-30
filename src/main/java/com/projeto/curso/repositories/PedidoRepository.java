	package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
