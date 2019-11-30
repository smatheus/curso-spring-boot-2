	package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
