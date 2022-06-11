package com.kruger.practica.servicio;

import com.kruger.practica.dto.VacunacionDTO;
import com.kruger.practica.excepciones.ResourceNotFoundException;
import com.kruger.practica.modelo.Empleado;
import com.kruger.practica.modelo.Vacuna;
import com.kruger.practica.modelo.Vacunacion;
import com.kruger.practica.repositorio.EmpleadoRepositorio;
import com.kruger.practica.repositorio.VacunaRepositorio;
import com.kruger.practica.repositorio.VacunacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacunacionServicioImpl implements VacunacionServicio{

    @Autowired
    VacunacionRepositorio vacunacionRepositorio;

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    VacunaRepositorio vacunaRepositorio;

    @Autowired
    EmpleadoServicio empleadoServicio;
    @Override
    public VacunacionDTO saveVacunacion(VacunacionDTO vacunacionDTO, Integer cpersona) {
        Empleado empleado = empleadoRepositorio.findById(cpersona).
                orElseThrow(() -> new ResourceNotFoundException("Empleado", "cempleado", cpersona));
        Vacuna vacuna = vacunaRepositorio.findById(vacunacionDTO.getVacunaDTO().getCvacuna()).
                orElseThrow(() -> new ResourceNotFoundException("Vacuna", "cvacuna", cpersona));
        Vacunacion vacunacion = mapearEntidad(vacunacionDTO);
        vacunacion.setCempleado(empleado);
        vacunacion.setCvacuna(vacuna);
        Vacunacion newVacunacion = vacunacionRepositorio.save(vacunacion);
        return mapearDTO(newVacunacion);
    }

    @Override
    public VacunacionDTO actualizarVacunacion(VacunacionDTO vacunacionDTO, Integer id) {
        return null;
    }

    @Override
    public List<VacunacionDTO> listadoPorVacuna(Integer idVacuna) {
        List<Vacunacion> vacunaciones = vacunacionRepositorio.findByVacunaId(idVacuna);
        return vacunaciones.stream().map(vacunacion -> mapearDTO(vacunacion)).collect(Collectors.toList());
    }

    @Override
    public List<VacunacionDTO> listadoPorEstado(boolean estado) {
        List<Vacunacion> vacunacionEstado = vacunacionRepositorio.findByEstado(estado);
        return vacunacionEstado.stream().map(vacunacion -> mapearDTO(vacunacion)).collect(Collectors.toList());
    }

    @Override
    public List<VacunacionDTO> listadoPorFechas(Date fecha1, Date fecha2) {
        List<Vacunacion> vacunacionFechas = vacunacionRepositorio.findFechas(fecha1, fecha2);
        return vacunacionFechas.stream().map(vacunacion -> mapearDTO(vacunacion)).collect(Collectors.toList());
    }

    /**
     *
     * @param vacunacion
     * @return
     */
    private VacunacionDTO mapearDTO(Vacunacion vacunacion) {
        VacunacionDTO vacunacionDTO = new VacunacionDTO();
        vacunacionDTO.setCodigo(vacunacion.getCodigo());
        vacunacionDTO.setFechaVacunacion(vacunacion.getFechaVacunacion());
        vacunacionDTO.setDosis(vacunacion.getDosis());
        vacunacionDTO.setEmpleadoDTO(empleadoServicio.mapearDTO(vacunacion.getCempleado()));
        return vacunacionDTO;
    }

    /**
     * Se convierte de dto a entidad
     * @param vacunacionDTO
     * @return
     */
    private Vacunacion mapearEntidad(VacunacionDTO vacunacionDTO) {
        Vacunacion vacunacion = new Vacunacion();
        vacunacion.setFechaVacunacion(vacunacionDTO.getFechaVacunacion());
        vacunacion.setDosis(vacunacionDTO.getDosis());
        return vacunacion;
    }
}