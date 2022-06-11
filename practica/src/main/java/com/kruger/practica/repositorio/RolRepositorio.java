package com.kruger.practica.repositorio;


import com.kruger.practica.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RolRepositorio extends CrudRepository<Rol, Long> {

	public Optional<Rol> findByNombre(String nombre);
	
}
