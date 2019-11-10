package com.projeto.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.curso.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResources {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L,"matheus","matheus@gmail.com","999999999", "123");
		return ResponseEntity.ok().body(u);
	}
}
