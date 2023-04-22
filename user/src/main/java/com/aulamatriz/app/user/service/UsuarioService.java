package com.aulamatriz.app.user.service;

import org.springframework.http.ResponseEntity;

import com.aulamatriz.app.user.dto.UsuarioDTO;
import com.aulamatriz.app.user.exeption.MyBisnessExepeption;


public interface UsuarioService {
	ResponseEntity guardarUsuario(UsuarioDTO usuarioDTO);
	ResponseEntity listarUsuarios();
	ResponseEntity deleteUsuarioByUsrname(String usrname);
	ResponseEntity updateUser(long id, UsuarioDTO usuarioDTO) throws MyBisnessExepeption;

}
