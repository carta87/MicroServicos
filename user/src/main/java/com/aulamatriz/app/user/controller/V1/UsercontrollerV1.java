package com.aulamatriz.app.user.controller.V1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulamatriz.app.user.controller.V1.doc.UserDoc;
import com.aulamatriz.app.user.dto.UsuarioDTO;
import com.aulamatriz.app.user.exeption.MyBisnessExepeption;
import com.aulamatriz.app.user.exeption.MyExceptionController;
import com.aulamatriz.app.user.producer.IEmailProduce;
import com.aulamatriz.app.user.service.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UsercontrollerV1 implements UserDoc{
	
	private final UsuarioService usuarioService;
	
	private final IEmailProduce iEmailProduce;

	@Override
	@GetMapping
	public ResponseEntity getAllUsers() {
		return usuarioService.listarUsuarios();
	}

	@Override
	@PostMapping
	public ResponseEntity crateUser(UsuarioDTO usuarioDTO) {
		return usuarioService.guardarUsuario(usuarioDTO);
	}

	@Override
	@DeleteMapping("/{username}")
	public ResponseEntity deleteUser(String username) {
		return usuarioService.deleteUsuarioByUsrname(username);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity udapteUser(long id, UsuarioDTO usuarioDTO)throws MyBisnessExepeption {
		return usuarioService.updateUser(id, usuarioDTO);
	}

	@Override
	@GetMapping("activemq/{message}")
	public ResponseEntity sendEmail(String message) throws MyBisnessExepeption{
		iEmailProduce.sendSimpleMessageTransaction(message);
		return ResponseEntity.ok("Se envio mensanje de forma exitosa");
	}
	
}
