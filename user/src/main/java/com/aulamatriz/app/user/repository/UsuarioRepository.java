package com.aulamatriz.app.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aulamatriz.app.user.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
	//JPQL
	@Query("Select u from UsuarioEntity u where u.email=?1")
	List<UsuarioEntity> buscarPorCorreo(String email);
	
	//JPA repository
	List<UsuarioEntity> findByEmail (String email);
	
	Optional<UsuarioEntity> findByUsername(String username);
	

}
