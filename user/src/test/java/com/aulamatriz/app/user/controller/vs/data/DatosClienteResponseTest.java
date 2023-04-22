package com.aulamatriz.app.user.controller.vs.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aulamatriz.app.user.model.UsuarioEntity;

public class DatosClienteResponseTest {
	
	

	public static ResponseEntity getResponseEntity () {
		ResponseEntity responseService = ResponseEntity
				.status(HttpStatus.CREATED)
				.body("fue creado con exito");
		return responseService;
		
	}
	
	public static ResponseEntity getAllUser() {
		List<UsuarioEntity> usuarioEntities = new ArrayList<>();
		
		 UsuarioEntity usuarioEntity = UsuarioEntity
	                .builder()
	                .nombre("Juliana")
	                .apellido("Arenas")
	                .email("juliArenas@hotmail.es")
	                .build();


		 usuarioEntities.add(usuarioEntity);

	        ResponseEntity responseService = ResponseEntity.ok(usuarioEntities);

	        return responseService;
	}

}
