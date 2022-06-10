package com.kruger.practica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacuna")
public class Vacuna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cvacuna")
	private Integer cvacuna;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;

	public Integer getCvacuna() {
		return cvacuna;
	}

	public void setCvacuna(Integer cvacuna) {
		this.cvacuna = cvacuna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
