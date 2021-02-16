package com.oscar.colegio.controlador;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.colegio.dtos.Asignatura;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.repositorios.AsignaturasRepository;

@Controller
public class AsignaturaController {

	@Autowired
	private AsignaturasRepository AR;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AsignaturaController.class);
	
	
	//Listar asignaturas
	@GetMapping (value = "listadoasignaturas")
	private String listadoAsignaturas (ModelMap model) {
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturas")
	public String listadoAsignaturas(@RequestParam(value = "id", required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		List<Asignatura> listaAsignaturas = AR.buscaAsignaturaporIdNombre(id, nombre);
		model.addAttribute("lista", listaAsignaturas);
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
//	//Insertar asignaturas
//	@GetMapping(value = "insertarasignaturas")
//	private String insertarAsignaturas(ModelMap model) {
//		return "vistas/asignaturas/insertarAsignaturas";
//	}
//	
//	@PostMapping(value = "insertarasignaturas")
//	public String insertarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
//			@RequestParam("nombre") String nombre, @RequestParam("curso") Integer curso,
//			@RequestParam("tasa") Double tasa, ModelMap model) {
//		AsignaturasEntity asignaturas = new AsignaturasEntity(id, nombre, curso, tasa);
//		AR.save(asignaturas);
//		return "vistas/asignaturas/insertarAsignaturas";
//	}
//	
	
	//Borrar asignaturas
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
	
	@PostMapping(value = "borrarasignatura")
	public String borrarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {
		AR.deleteById(id);
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	
//	//Actualizar asignaturas
//	@GetMapping(value = "formulariomodificarasignaturas")
//	private String modificarAsignatura(ModelMap model) {
//		return "vistas/asignaturas/modificarAsignaturas";
//	}
//	
//	@PostMapping(value = "formulariomodificarasignaturas")
//	public String formularioModificarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
//			@RequestParam("nombre") String nombre, ModelMap model) {
//		List<Asignatura> listaAsignaturas = AR.buscaAsignaturaporIdNombre(id, nombre);
//		model.addAttribute("lista", listaAsignaturas);
//		return "vistas/asignaturas/modificarAsignaturas";
//	}
//	
//	@PostMapping(value = "modificarasignaturas")
//	public String modificarAsignatura(
//			@RequestParam(value = "id", required = false) Integer id,
//			@RequestParam("nombre") String nombre, 
//			@RequestParam("curso") Integer curso,
//			@RequestParam("tasa") Double tasa, ModelMap model) {
//		
//		AsignaturasEntity asignaturas = new AsignaturasEntity(id, nombre, curso, tasa);
//		AR.save(asignaturas);
//		return "vistas/asignaturas/modificarAsignaturas";
//	}
//	
	
	
}