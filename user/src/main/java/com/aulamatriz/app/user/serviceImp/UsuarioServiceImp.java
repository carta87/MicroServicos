package com.aulamatriz.app.user.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aulamatriz.app.user.dto.UsuarioDTO;
import com.aulamatriz.app.user.exeption.MyBisnessExepeption;
import com.aulamatriz.app.user.mapper.UserMapper;
import com.aulamatriz.app.user.model.UsuarioEntity;
import com.aulamatriz.app.user.repository.UsuarioRepository;
import com.aulamatriz.app.user.service.UsuarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImp implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	/*@Override este codigo muestra que no se aplica el princio de responsabilidad unica
	public ResponseEntity guardarUsuario(UsuarioDTO usuarioDTO) {
		
		List<UsuarioEntity> usuarioEntities = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		
		//usuarioEntities.stream().filter(user -> user.getEmail() =="");
		if(usuarioEntities.size() == 0) {
			UsuarioEntity usuarioEntity = UsuarioEntity
					.builder()
					.nombre(usuarioDTO.getNombre())
					.apellido(usuarioDTO.getApellido())
					.username(usuarioDTO.getUsername())
					.password(usuarioDTO.getPassword())
					.email(usuarioDTO.getEmail())
					.telefono(usuarioDTO.getTelefono())
					.build();
				
			usuarioRepository.save(usuarioEntity);
			return ResponseEntity.status(HttpStatus.CREATED).body("fue creado con exto el usuario");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el correo ya existe");
			
		}
	}*/


	
	@Override
	public ResponseEntity guardarUsuario(UsuarioDTO usuarioDTO) {
		
		List<UsuarioEntity> usuarioEntities = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		
		//usuarioEntities.stream().filter(user -> user.getEmail() =="");
		if(usuarioEntities.size() == 0) {
			
			var newUser = UserMapper.getUsertDtoToUsrEntity(usuarioEntities.get(0), usuarioDTO);
				
			usuarioRepository.save(newUser);
			return ResponseEntity.status(HttpStatus.CREATED).body("fue creado con exto el usuario");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el correo ya existe");
			
		}
	}
	
	/*@Override este codigo muestra que no se aplica el princio de responsabilidad unica
	public ResponseEntity guardarUsuario(UsuarioDTO usuarioDTO) {
		
		List<UsuarioEntity> usuarioEntities = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		
		//usuarioEntities.stream().filter(user -> user.getEmail() =="");
		if(usuarioEntities.size() == 0) {
			UsuarioEntity usuarioEntity = UsuarioEntity
					.builder()
					.nombre(usuarioDTO.getNombre())
					.apellido(usuarioDTO.getApellido())
					.username(usuarioDTO.getUsername())
					.password(usuarioDTO.getPassword())
					.email(usuarioDTO.getEmail())
					.telefono(usuarioDTO.getTelefono())
					.build();
				
			usuarioRepository.save(usuarioEntity);
			return ResponseEntity.status(HttpStatus.CREATED).body("fue creado con exto el usuario");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el correo ya existe");
			
		}
	}*/



	@Override
	public ResponseEntity listarUsuarios() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@Override
	public ResponseEntity deleteUsuarioByUsrname(String usrname) {
		Optional<UsuarioEntity> optional = usuarioRepository.findByUsername(usrname);
		//var usuarioOptional optioanlUsuario = usuarioRepository.findByUsername(usrname);
		
		ResponseEntity outMessage =null;
		if(optional.isPresent()) {
			usuarioRepository.delete(optional.get());
			outMessage = ResponseEntity.status(HttpStatus.CREATED).body("fue eliminado usuario" + usrname);
			
		}else {
			outMessage = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario" + usrname +"no existe");
		}
		return outMessage;
	}

	@Override
	public ResponseEntity updateUser(long id, UsuarioDTO usuarioDTO) throws MyBisnessExepeption {
		ResponseEntity outMessage =null;
		Optional<UsuarioEntity> usuarioOptional =  usuarioRepository.findById(id);
		if(!usuarioOptional.isPresent()) {
			//return outMessage = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no existe");
				throw new MyBisnessExepeption( "el usuario que desea modificar no existe");
		}
		
		var newUser = UserMapper.getUserDtoToUsrEntity(id, usuarioDTO);
		
		var user = usuarioRepository.save(newUser);
		outMessage = ResponseEntity.ok(user);
		
		return outMessage;

	}

	
	
}
