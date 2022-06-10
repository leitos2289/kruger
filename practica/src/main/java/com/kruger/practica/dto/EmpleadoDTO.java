package com.kruger.practica.dto;

import java.sql.Date;

public class EmpleadoDTO {
	
	private Integer cempleado;
	
	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private Date fechaNacimiento;
	
	private String Direccion;
	
	private String movil;
	
	private boolean vacunado;

	public Integer getCempleado() {
		return cempleado;
	}

	public void setCempleado(Integer cempleado) {
		this.cempleado = cempleado;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public boolean isVacunado() {
		return vacunado;
	}

	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}
	
	
}
