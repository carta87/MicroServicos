package com.aulamatriz.app.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulamatriz.app.user.dto.UsuarioDTO;
import com.aulamatriz.app.user.model.UsuarioEntity;
import com.aulamatriz.app.user.service.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class Usuariocontroller {
	
	private  final UsuarioService usuarioService;
	
	@PostMapping("/guardar")
	ResponseEntity guardarUsurio(@RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.guardarUsuario(usuarioDTO);
		
	}
	
	@GetMapping("/listarUsuarios")
	ResponseEntity listarUsusarios() {
		return usuarioService.listarUsuarios();
	}

}
