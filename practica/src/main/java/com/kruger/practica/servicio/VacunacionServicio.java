package com.kruger.practica.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.practica.modelo.Vacunacion;
import com.kruger.practica.repositorio.VacunacionRepositorio;

@Service
public class VacunacionServicio {
	
	@Autowired
	VacunacionRepositorio vacunacionRepositorio;
	
	public Vacunacion saveVacunacion(Vacunacion vacunacion) {
		vacunacionRepositorio.save(vacunacion);
		return vacunacion;
	}

	public Vacunacion listarVacuncacion(){
		
		Optional<Vacunacion> lista = vacunacionRepositorio.findById(1);
		return lista.get();
	}
	
}
