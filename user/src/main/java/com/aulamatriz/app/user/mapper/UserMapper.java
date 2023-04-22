package com.aulamatriz.app.user.mapper;

import com.aulamatriz.app.user.dto.UsuarioDTO;
import com.aulamatriz.app.user.model.UsuarioEntity;

public class UserMapper {
	
	public static UsuarioEntity getUserDtoToUsrEntity(long userId, UsuarioDTO usuarioDTO) {	
		return UsuarioEntity
				.builder()
				.usuarioId(userId)
				.nombre(usuarioDTO.getNombre())
				.apellido(usuarioDTO.getApellido())
				.username(usuarioDTO.getUsername())
				.password(usuarioDTO.getPassword())
				.email(usuarioDTO.getEmail())
				.telefono(usuarioDTO.getTelefono())
				.build();
	}
	
	public static UsuarioEntity getUsertDtoToUsrEntity(UsuarioEntity usuarioEntity, UsuarioDTO usuarioDTO) {	
		 usuarioEntity.setNombre(usuarioDTO.getNombre());
		 usuarioEntity.setApellido(usuarioDTO.getApellido());
		 usuarioEntity.setEmail(usuarioDTO.getEmail());
		 usuarioEntity.setTelefono(usuarioDTO.getTelefono());
		 usuarioEntity.setUsername(usuarioDTO.getUsername());
		 usuarioEntity.setPassword(usuarioDTO.getPassword());
		 
		 return usuarioEntity;
	}

}
