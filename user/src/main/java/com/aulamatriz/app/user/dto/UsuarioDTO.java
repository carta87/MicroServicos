package com.aulamatriz.app.user.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aulamatriz.app.user.model.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class UsuarioDTO {
	
	private String nombre;
	private String apellido;
	@Size(min = 5)
	private String password;
	private String username;
	private String telefono;
	@NotNull
	@NotEmpty
	private String email;

}
