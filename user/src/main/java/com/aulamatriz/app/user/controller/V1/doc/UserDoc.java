package com.aulamatriz.app.user.controller.V1.doc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aulamatriz.app.user.dto.UsuarioDTO;
import com.aulamatriz.app.user.exeption.MyBisnessExepeption;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

import org.springframework.http.MediaType;



@Tag(name = "API para el crud  basico de un usuario")
public interface UserDoc {
	
	@Operation(summary = "Listar todos los usuarios de la aplicacion")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "listar usuarios",
							content = {
									@Content (
											mediaType = MediaType.APPLICATION_JSON_VALUE	
								)
							}
					)
			}
	)
	ResponseEntity getAllUsers();
	
	@Operation(summary = "crear usuario con la palicacion")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "201",
							description = "usuario creado",
							content = {
									@Content (
											mediaType = MediaType.APPLICATION_JSON_VALUE	
								)
							}
					)
			}
		)
	ResponseEntity crateUser(@Valid @RequestBody UsuarioDTO usuarioDTO);
	
	@Operation(summary = "usuario Eliminado de la palicacion")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							
							description = "usuario eliminado",
							content = {
									@Content (
											mediaType = MediaType.APPLICATION_JSON_VALUE	
								)
							}
					)
			}
		)
	
	ResponseEntity deleteUser(@PathVariable String username);
	
	@Operation(summary = "actualiza usuario de la palicacion")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							
							description = "usuario actualizado",
							content = {
									@Content (
											mediaType = MediaType.APPLICATION_JSON_VALUE	
								)
							}
					)
			}
		)
	
	ResponseEntity udapteUser(@PathVariable long id, @RequestBody UsuarioDTO usuarioDTO)throws MyBisnessExepeption;
	
	@Operation(summary = "Sercicio de envio de messajes")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							
							description = "mensaje enviado",
							content = {
									@Content (
											mediaType = MediaType.APPLICATION_JSON_VALUE	
								)
							}
					)
			}
		)
	
	ResponseEntity sendEmail (@PathVariable String message)throws MyBisnessExepeption;


}
