package com.kruger.practica.servicio;

import java.util.List;

import com.kruger.practica.dto.EmpleadoDTO;

public interface EmpleadoServicio {
	
	public EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO);
	public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO, Integer cpersona);
	public List<EmpleadoDTO> empleadosListado();
	public EmpleadoDTO obtenerEmpleadoPorId(Integer id);

}
