package com.oscar.colegio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.colegio.dtos.Asignatura;
import com.oscar.colegio.dtos.AsignaturaDTO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.repositorios.AsignaturaRepository;

@Controller
public class AsignaturasController {
	
	@Autowired
	private AsignaturaRepository AR;
	
	
	// INSERTAR -------------------------------------------------------------------------------------------------
	@GetMapping(value = "insertarasignatura") // nueva forma de mapearlo la URL al fichero JSP
	public String formularioInsertarAsignaturas(ModelMap model) {
		// mapeoEntidadesMunicipioComboDTO
		return "vistas/asignaturas/insertarAsignaturas";
		
	}
	
	@PostMapping(value ="insertarasignatura")
	public String formularioInsertarAsignaturass(
		@RequestParam(value= "id", required = false) Integer id,
		@RequestParam("nombre") String nombre,
		@RequestParam(value = "curso") Integer curso,
		@RequestParam(value = "tasa") Double tasa,
		ModelMap model){
		
		AsignaturasEntity asig = new AsignaturasEntity(id, nombre, curso, tasa);
		AR.save(asig);
			return "vistas/asignaturas/insertarAsignaturas";
		}
	
	// LISTAR -------------------------------------------------------------------------------------------------
	@GetMapping(value = "listadoasignaturas")
	public String listaGet(ModelMap model) {
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturas")
	public String listarAsignaturas(
			@RequestParam(value = "id",required = false) Integer id,
			@RequestParam("nombre") String nombre,
			ModelMap model) {
		
		List<Asignatura> listaAsignatura = AR.buscaAsignaturaporIdNombre(id, nombre);
		model.addAttribute("lista", listaAsignatura);
		
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	// ACTUALIZAR -------------------------------------------------------------------------------------------------
	@GetMapping(value = "formularioactualizarasignatura")//muestra vista
	public String formularioModificar(ModelMap model) {
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "formularioactualizarasignatura")// lista para modificar
	public String listaModificar(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre,
			ModelMap model) {
		
			List<Asignatura> listaAsignatura = AR.buscaAsignaturaporIdNombre(id, nombre);
			model.addAttribute("lista", listaAsignatura);
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "actualizarasignatura") // Realiza los cambios
	public String RealizacambiosModificar(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre,
			@RequestParam("curso") Integer curso,
			@RequestParam("tasa") Double tasa) {
		
		AsignaturasEntity asig = new AsignaturasEntity(id, nombre, curso, tasa);
		AR.save(asig);
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	// BORRAR -------------------------------------------------------------------------------------------------
	
	@GetMapping(value = "formularioborrarasignatura")
	private String borrarAsignatura(ModelMap model) {
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	@PostMapping(value = "formularioborrarasignatura")
	public String formularioBorrarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {
		List<Asignatura> listaAsignaturas = AR.buscaAsignaturaporIdNombre(id, nombre);
		model.addAttribute("lista", listaAsignaturas);
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
//	@PostMapping(value = "borrarasignatura")
//	public String borrarAsignatura(@RequestParam(value = "id", required = false) Integer id,
//			ModelMap model) {
//		AR.deleteById(id);
//		return "vistas/asignaturas/borrarAsignaturas";
//
//	}
	
	@PostMapping(value = "borrarasignatura")
	public String borrarAsignaturaa(
			@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {
		
	
		AR.deleteById(id); // inyectamos con el autowired
		
		return "vistas/asignaturas/borrarAsignaturas";
	}
	


}
