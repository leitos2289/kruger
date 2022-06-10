package com.kruger.practica.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kruger.practica.dto.EmpleadoDTO;
import com.kruger.practica.excepciones.ResourceNotFoundException;
import com.kruger.practica.modelo.Empleado;
import com.kruger.practica.common.Validaciones;
import com.kruger.practica.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{
	
	private static Logger log = LoggerFactory.getLogger(EmpleadoServicioImpl.class.getName());
	
	@Autowired
	EmpleadoRepositorio empleadoRepositorio;

	@Override
	public EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO) {
		return this.guardarEmpleado(empleadoDTO);
	}
	
	private EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO) {
		if(Validaciones.getInstance().validarCedula(empleadoDTO.getCedula())) {
			Empleado empleado = this.mapearEntidad(empleadoDTO);
			Empleado newEmpleado = empleadoRepositorio.save(empleado);
			EmpleadoDTO empleadoRes = this.mapearDTO(newEmpleado);
			return empleadoRes;
		}
		return empleadoDTO;
	}

	@Override
	public List<EmpleadoDTO> empleadosListado() {
		List<Empleado> empleados = (List<Empleado>) empleadoRepositorio.findAll();
		return empleados.stream().map(empleado -> mapearDTO(empleado)).collect(Collectors.toList());
	}
	
	/**
	 * Se convierte entidad a dto
	 * @param empleado
	 * @return
	 */
	private EmpleadoDTO mapearDTO(Empleado empleado) {
		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		empleadoDTO.setCempleado(empleado.getCempleado());
		empleadoDTO.setNombre(empleado.getNombre());
		empleadoDTO.setApellido(empleado.getApellido());
		empleadoDTO.setEmail(empleado.getEmail());
		empleadoDTO.setCedula(empleado.getCedula());
		
		return empleadoDTO;
	}
	
	/**
	 * Se convierte de dto a entidad
	 * @param empleadoDTO
	 * @return
	 */
	private Empleado mapearEntidad(EmpleadoDTO empleadoDTO) {
		Empleado empleado = new Empleado();
		empleado.setCempleado(empleadoDTO.getCempleado());
		empleado.setNombre(empleadoDTO.getNombre());
		empleado.setApellido(empleadoDTO.getApellido());
		empleado.setEmail(empleadoDTO.getEmail());
		empleado.setCedula(empleadoDTO.getCedula());
		return empleado;
	}

	@Override
	public EmpleadoDTO obtenerEmpleadoPorId(Integer id) {
		Empleado empleado = empleadoRepositorio.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Empleado", "cempleado", id));

		return mapearDTO(empleado);
	}

	@Override
	public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO, Integer cpersona) {
		Empleado empleado = empleadoRepositorio.findById(cpersona).
				orElseThrow(() -> new ResourceNotFoundException("Empleado", "cempleado", cpersona));
		empleado.setNombre(empleadoDTO.getNombre());
		empleado.setApellido(empleadoDTO.getApellido());
		empleado.setEmail(empleadoDTO.getEmail());
		empleado.setCedula(empleadoDTO.getCedula());
		
		Empleado updateEmpleado = empleadoRepositorio.save(empleado);
		return mapearDTO(updateEmpleado);
	}

}
