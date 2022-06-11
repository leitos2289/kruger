package com.kruger.practica.servicio;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.kruger.practica.dto.RegistroDTO;
import com.kruger.practica.excepciones.AppException;
import com.kruger.practica.modelo.Rol;
import com.kruger.practica.modelo.Usuario;
import com.kruger.practica.repositorio.RolRepositorio;
import com.kruger.practica.repositorio.UsuarioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private RolRepositorio rolRepositorio;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO, RegistroDTO registroDTO) throws Exception {
		try {
			return this.guardarEmpleado(empleadoDTO, registroDTO);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	private EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO, RegistroDTO registroDTO) throws Exception {
		if(Validaciones.getInstance().validarCedula(empleadoDTO.getCedula())) {
			Empleado empleado = this.mapearEntidad(empleadoDTO);
			Empleado newEmpleado = empleadoRepositorio.save(empleado);
			EmpleadoDTO empleadoRes = this.mapearDTO(newEmpleado);
			this.guardarUsuario(registroDTO);
			return empleadoRes;
		}
		throw new Exception("Cédula incorrecta");
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
	@Override
	public EmpleadoDTO mapearDTO(Empleado empleado) {
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
	public Empleado mapearEntidad(EmpleadoDTO empleadoDTO) {
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
		Empleado empleado = buscarEmpleado(id);

		return mapearDTO(empleado);
	}

	@Override
	public void eliminarEmpleado(Integer cpersona) {
		Empleado empleado = buscarEmpleado(cpersona);
		empleadoRepositorio.delete(empleado);
	}

	@Override
	public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO, boolean estado) {
		Empleado empleado = buscarEmpleado(empleadoDTO.getCempleado());
		if (estado){
			empleado.setNombre(empleadoDTO.getNombre());
			empleado.setApellido(empleadoDTO.getApellido());
			empleado.setEmail(empleadoDTO.getEmail());
			empleado.setCedula(empleadoDTO.getCedula());
		}else {
			empleado.setDireccion(empleadoDTO.getDireccion());
			empleado.setFechaNacimiento(empleadoDTO.getFechaNacimiento());
			empleado.setMovil(empleadoDTO.getMovil());
			empleado.setVacunado(empleadoDTO.isVacunado());
		}
		Empleado updateEmpleado = empleadoRepositorio.save(empleado);
		return mapearDTO(updateEmpleado);
	}

	public Empleado buscarEmpleado(Integer cpersona){
		return empleadoRepositorio.findById(cpersona).
				orElseThrow(() -> new ResourceNotFoundException("Empleado", "cempleado", cpersona));

	}

	public void guardarUsuario(RegistroDTO registroDTO){
		if(!usuarioRepositorio.existsByUsername(registroDTO.getUsername())
				&& !usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
			Usuario usuario = new Usuario();
			usuario.setNombre(registroDTO.getNombre());
			usuario.setUsername(registroDTO.getUsername());
			usuario.setEmail(registroDTO.getEmail());
			usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
			Rol roles = rolRepositorio.findByNombre("ROLE_USER").get();
			usuario.setRoles(Collections.singleton(roles));
			usuarioRepositorio.save(usuario);
		}


	}

}
