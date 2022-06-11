package com.kruger.practica.repositorio;

import com.kruger.practica.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
	
	public Optional<Usuario> findByUsernameOrEmail(String username,String email);
	
	public Optional<Usuario> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
	
}
