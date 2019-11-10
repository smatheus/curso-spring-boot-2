package com.projeto.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.curso.entidades.Usuario;
import com.projeto.curso.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResources {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
