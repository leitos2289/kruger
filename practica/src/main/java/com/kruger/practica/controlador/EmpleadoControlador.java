package com.kruger.practica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.practica.dto.EmpleadoDTO;
import com.kruger.practica.servicio.EmpleadoServicioImpl;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {
	
	@Autowired
	EmpleadoServicioImpl empleadoServicio;
	
	@PostMapping("/save")
	public ResponseEntity<EmpleadoDTO> save(@RequestBody EmpleadoDTO empleadoDTO) {
		return new ResponseEntity<>(empleadoServicio.saveEmpleado(empleadoDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/listado")
	public List<EmpleadoDTO> listadoEmpleado(){
		return empleadoServicio.empleadosListado();
	}
	
	@GetMapping("/listado/{id}")
	public ResponseEntity<EmpleadoDTO> obtenerEmpleadoId(@PathVariable(name = "id")  Integer id) {
		return ResponseEntity.ok(empleadoServicio.obtenerEmpleadoPorId(id));
		
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO, @PathVariable(name = "id") Integer id){
		EmpleadoDTO empleadoRes = empleadoServicio.actualizarEmpleado(empleadoDTO, id);
		return new ResponseEntity<>(empleadoRes, HttpStatus.OK);
	}

}
