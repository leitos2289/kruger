package com.kruger.practica.servicio;

import java.util.List;

import com.kruger.practica.dto.EmpleadoDTO;
import com.kruger.practica.dto.RegistroDTO;
import com.kruger.practica.modelo.Empleado;

public interface EmpleadoServicio {
	
	public EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO, RegistroDTO registroDTO) throws Exception;
	public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO, boolean estado);
	public List<EmpleadoDTO> empleadosListado();
	public EmpleadoDTO obtenerEmpleadoPorId(Integer id);
	public void eliminarEmpleado(Integer cpersona);
	public EmpleadoDTO mapearDTO(Empleado empleado);

}
