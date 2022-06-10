package com.kruger.practica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.practica.modelo.Vacunacion;
import com.kruger.practica.servicio.VacunacionServicio;

@RestController
@RequestMapping("/vacunacion")
public class VacunacionControlador {
	
	@Autowired
	VacunacionServicio vacunacionServicio;
	
	@PostMapping("/save")
	public Vacunacion save(@RequestBody Vacunacion vacunacion) {
		
		return vacunacionServicio.saveVacunacion(vacunacion);
	}

	@GetMapping("/listar")
	public Vacunacion listar(){
		return vacunacionServicio.listarVacuncacion();
	}
}
