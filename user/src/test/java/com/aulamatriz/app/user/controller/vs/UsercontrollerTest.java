package com.aulamatriz.app.user.controller.vs;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import com.aulamatriz.app.user.UserApplication;
import com.aulamatriz.app.user.controller.vs.data.DatosClienteResponseTest;
import com.aulamatriz.app.user.dto.UsuarioDTO;
import com.aulamatriz.app.user.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = UserApplication.class)
@AutoConfigureMockMvc
public class UsercontrollerTest {
	 
	@Autowired
	private MockMvc mvc;
	
	@MockBean //quemar la respuesta
	UsuarioService usuarioService;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp(){
		this.objectMapper = new ObjectMapper();
	}
	
	String url = "/v1/user";
	
	
	@Test
	void createUserTest () throws Exception{
		
		UsuarioDTO usuarioDTO = UsuarioDTO.builder()
				.email("carta@hotmail")
				.password("sssas")		
				.build();
		
		when(usuarioService.guardarUsuario(any())
			).thenReturn(DatosClienteResponseTest.getResponseEntity());
		
		mvc.perform(
				post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(usuarioDTO))
				).andExpect(status().isCreated());
		 
	}
	
	@Test
	void getAllUserTestOk () throws Exception{
		
		when(usuarioService.listarUsuarios()
			).thenReturn(DatosClienteResponseTest.getAllUser());
		
		mvc.perform(
				get(url)
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
				 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
			     .andExpect(jsonPath("$[0].nombre").value("Juliana"))
			     .andExpect(jsonPath("$[0].email").value("juliArenas@hotmail.es")); 
		        
	}	
}
