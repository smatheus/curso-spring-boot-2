package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
