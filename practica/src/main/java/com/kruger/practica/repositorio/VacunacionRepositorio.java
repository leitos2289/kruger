package com.kruger.practica.repositorio;

import com.kruger.practica.dto.VacunacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kruger.practica.modelo.Vacunacion;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface VacunacionRepositorio extends CrudRepository<Vacunacion, Integer> {

    @Query("from Vacunacion v where v.vacuna.cvacuna= ?1")
    public List<Vacunacion> findByVacunaId(Integer vacunaId);

    @Query("from Vacunacion v where v.empleado.vacunado= ?1")
    public List<Vacunacion> findByEstado(boolean estado);

    @Query(value = "from Vacunacion v " +
            "where DATE(v.fechaVacunacion) BETWEEN ?1 and ?2")
    public List<Vacunacion> findFechas(Date fechaInicio, Date fechaFin);
}
