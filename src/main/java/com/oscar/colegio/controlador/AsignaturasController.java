package com.oscar.colegio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.colegio.dao.AsignaturasDAO;
import com.oscar.colegio.dao.impl.AsignaturasDAOImpl;
import com.oscar.colegio.dtos.Asignatura;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.repositorios.AsignaturaRepository;

@Controller
public class AsignaturasController {
	
	@Autowired
	private AsignaturaRepository AR;
	
	@Autowired
	private AsignaturasDAO asiganutaImpl;
	
	
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
		
		model.addAttribute("resutado", asiganutaImpl.insertarAsignatura(id, nombre, curso, tasa));
			return "vistas/asignaturas/insertarAsignaturas";
		}
	
	// LISTAR -------------------------------------------------------------------------------------------------
	@GetMapping(value = "listadoasignaturas")
	public String listaGet(ModelMap model) {
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturas")
	public String listarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model)  {
		
		model.addAttribute("lista", asiganutaImpl.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));

		
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	// ACTUALIZAR -------------------------------------------------------------------------------------------------

	@GetMapping(value = "formularioactualizarasignatura")
	public String FormularioActualizarAsignaturas() {
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "formularioactualizarasignatura")
	public String FormularioActualizarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre,
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model) {
		
		model.addAttribute("lista", asiganutaImpl.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "actualizarasignatura")
	public String ActualizarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model){	
				
		model.addAttribute("resultado", asiganutaImpl.actualizarAsignatura(id, nombre, curso, tasa));		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	// BORRAR -------------------------------------------------------------------------------------------------
	
	@GetMapping(value = "formularioborrarasignatura")
	private String borrarAsignatura(ModelMap model) {
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	@PostMapping(value = "formularioborrarasignatura")
	public String FormularioBorrarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model) {
		
		model.addAttribute("lista", asiganutaImpl.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	@PostMapping(value = "borrarasignatura")
	public String borrarAsignaturaa(
			@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {
		model.addAttribute("resultado", asiganutaImpl.eliminarAsignatura(id));
		
		return "vistas/asignaturas/borrarAsignaturas";
	}
	


}
