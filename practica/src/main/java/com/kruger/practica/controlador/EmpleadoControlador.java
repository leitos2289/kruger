package com.kruger.practica.controlador;

import java.util.List;

import com.kruger.practica.dto.RegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kruger.practica.dto.EmpleadoDTO;
import com.kruger.practica.servicio.EmpleadoServicioImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoControlador {
	
	@Autowired
	EmpleadoServicioImpl empleadoServicio;
	@GetMapping("/listado")
	public List<EmpleadoDTO> listadoEmpleado(){
		return empleadoServicio.empleadosListado();
	}
	
	@GetMapping("/listado/{id}")
	public ResponseEntity<EmpleadoDTO> obtenerEmpleadoId(@PathVariable(name = "id")  Integer id) {
		return ResponseEntity.ok(empleadoServicio.obtenerEmpleadoPorId(id));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<EmpleadoDTO> save(@Valid @RequestBody EmpleadoDTO empleadoDTO) throws Exception {
		RegistroDTO registroDTO = new RegistroDTO();
		registroDTO.setNombre(empleadoDTO.getNombre().concat(" ").concat(empleadoDTO.getApellido()));
		registroDTO.setEmail(empleadoDTO.getEmail());
		registroDTO.setUsername(empleadoDTO.getEmail());
		registroDTO.setPassword("1234");
		return new ResponseEntity<>(empleadoServicio.saveEmpleado(empleadoDTO, registroDTO), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('USER')")
	@PutMapping("/actualizar")
	public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
		EmpleadoDTO empleadoRes = empleadoServicio.actualizarEmpleado(empleadoDTO, true);
		return new ResponseEntity<>(empleadoRes, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarEmpleado(@PathVariable(name = "id") Integer id){
		empleadoServicio.eliminarEmpleado(id);
		return new ResponseEntity<>("Empleado eliminado exitosamente", HttpStatus.OK);
	}
}
