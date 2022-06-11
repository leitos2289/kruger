package com.kruger.practica.servicio;

import com.kruger.practica.dto.VacunacionDTO;

import java.sql.Date;
import java.util.List;

public interface VacunacionServicio {
	public VacunacionDTO saveVacunacion(VacunacionDTO vacunacionDTO, Integer cpersona);
	public VacunacionDTO actualizarVacunacion(VacunacionDTO vacunacionDTO, Integer id);
	public List<VacunacionDTO> listadoPorVacuna (Integer idVacuna);
	public List<VacunacionDTO> listadoPorEstado (boolean estado);
	public List<VacunacionDTO> listadoPorFechas (Date fecha1, Date fecha2);
	
}
