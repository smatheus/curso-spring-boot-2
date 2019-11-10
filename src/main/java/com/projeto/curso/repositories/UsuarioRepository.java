package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
