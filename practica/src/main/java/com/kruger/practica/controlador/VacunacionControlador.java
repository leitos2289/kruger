package com.kruger.practica.controlador;

import com.kruger.practica.dto.VacunacionDTO;
import com.kruger.practica.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.kruger.practica.servicio.VacunacionServicio;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vacunacion")
public class VacunacionControlador {
	
	@Autowired
	VacunacionServicio vacunacionServicio;

	@Autowired
	EmpleadoServicio empleadoServicio;

	@PostMapping("/save")
	public VacunacionDTO save(@RequestBody VacunacionDTO vacunacionDTO) {
		empleadoServicio.actualizarEmpleado(vacunacionDTO.getEmpleadoDTO(), false);
		if(vacunacionDTO.getEmpleadoDTO().isVacunado()){
			return vacunacionServicio.saveVacunacion(vacunacionDTO, vacunacionDTO.getEmpleadoDTO().getCempleado());
		}else {
			return vacunacionDTO;
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listar/estadovacunacion/{estado}")
	public List<VacunacionDTO> listar(@PathVariable(name = "estado") boolean estado){
		return vacunacionServicio.listadoPorEstado(estado);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listar/porvacuna/{vacuna}")
	public List<VacunacionDTO> listar(@PathVariable(name = "vacuna") Integer vacuna){
		return vacunacionServicio.listadoPorVacuna(vacuna);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/listar/porfecha")
	public List<VacunacionDTO> estadocuenta(@RequestParam(value = "fecha1") Date fecha1, @RequestParam(value = "fecha2") Date fecha2) {
		return vacunacionServicio.listadoPorFechas(fecha1, fecha2);
	}
}
