package com.kruger.practica.dto;

import java.sql.Date;

import com.kruger.practica.modelo.Empleado;
import com.kruger.practica.modelo.Vacuna;

public class VacunacionDTO {
	
	
	private Integer codigo;
	
	Date fechaVacunacion;
	
	private Integer dosis;
	
	private Empleado empleado;
	
	private Vacuna vacuna;

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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
	
	
}
