package com.kruger.practica.dto;

import java.sql.Date;

import com.kruger.practica.modelo.Empleado;
import com.kruger.practica.modelo.Vacuna;

public class VacunacionDTO {
	
	
	private Integer codigo;
	
	Date fechaVacunacion;
	
	private Integer dosis;
	
	private EmpleadoDTO empleadoDTO;
	
	private VacunaDTO vacunaDTO;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public Integer getDosis() {
		return dosis;
	}

	public void setDosis(Integer dosis) {
		this.dosis = dosis;
	}

	public EmpleadoDTO getEmpleadoDTO() {
		return empleadoDTO;
	}

	public void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
		this.empleadoDTO = empleadoDTO;
	}

	public VacunaDTO getVacunaDTO() {
		return vacunaDTO;
	}

	public void setVacunaDTO(VacunaDTO vacunaDTO) {
		this.vacunaDTO = vacunaDTO;
	}
	
	
}
