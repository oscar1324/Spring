package com.oscar.colegio.controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.colegio.dao.CombosDAO;
import com.oscar.colegio.dtos.AlumnoDTO;
import com.oscar.colegio.dtos.ComboDTO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.MunicipiosEntity;
import com.oscar.colegio.repositorios.AlumnoRepository;
import com.oscar.colegio.repositorios.MunicipioRepository;


@Controller
public class AlumnosController {
	
	@Autowired
	private CombosDAO cc;
	
	@Autowired // Realizamos insercción
	private AlumnoRepository AlumnoRepo;
	
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnosController.class);
	
	@GetMapping(value = "insertaralumno") // nueva forma de mapearlo la URL al fichero JSP
	public String formularioInsertarAlumnos(ModelMap model) {
		model.addAttribute("listaMunicipios", cc.comboMunicipios());
		// mapeoEntidadesMunicipioComboDTO
		return "vistas/alumnos/insertarAlumnos";
		
	}

	
	@PostMapping(value = "insertaralumno")
	public String InsertarAlumno(
			@RequestParam(value= "id", required = false) Integer id,
			@RequestParam("nombre")String nombre,
			@RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value=" familiaNumerosa",required = false) Integer famNumerosa,
			ModelMap model) {
		
			famNumerosa = (famNumerosa == null) ? 0 : 1;
			
			// Creación entidad alumno
			AlumnoEntity alumno = new AlumnoEntity(id, nombre, idMunicipio, famNumerosa);
			// Guardar Enitdad Alumno
			AlumnoRepo.save(alumno);
			
			// Realizar combos de alumnos y los que sean necesarios
			model.addAttribute("listaMunicipios" , cc.comboMunicipios());
	return "vistas/alumnos/insertarAlumnos";
	
	}
	
	
	@GetMapping(value = "listadoalumnos")
	public String Hola (ModelMap model) {
		return "vistas/alumnos/listadoAlumnos";
	}
	
	@PostMapping(value = "listadoalumnos")
	public String listadoAlumnos(
			@RequestParam(value ="id", required = false) Integer id,
			@RequestParam("nombre") String nombre,
			ModelMap model) {
		List<AlumnoDTO> listaAlumnos = AlumnoRepo.buscarAlumnoporIDyNombre(id,nombre);
		// llamo a AlumnoRepo, que es la inserción del autowired
		model.addAttribute("lista", listaAlumnos);
		return "vistas/alumnos/listadoAlumnos";
	}
	
	
	// Actualizar  
	
	
	@GetMapping(value = "formularioactualizaralumnos")
	public String Hola2 (ModelMap model) {
		return "vistas/alumnos/actualizarAlumnos";
	}
	
	@PostMapping(value = "formularioactualizaralumnos")
	public String formularioactualizarAlumno(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre,
			ModelMap model) {
			List<AlumnoDTO> listaAlumnos = AlumnoRepo.buscarAlumnoporIDyNombre(id,nombre);
			model.addAttribute("lista", listaAlumnos);
		
		return "vistas/alumnos/actualizarAlumnos";
		/*Lo que estamos consiguendo es qe recupere el id y nombre además de mostrar la lista*/
	}
	
	@PostMapping(value = "actualizaralumno")
	public String actualizarAlumno(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre,
			@RequestParam(value = "municipios")Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa", required = false) String famNumerosa,
			ModelMap model) {
		
		famNumerosa = (famNumerosa == null) ? "0" : "1";
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, idMunicipio, Integer.parseInt(famNumerosa));
		AlumnoRepo.save(alumno); // inyectamos con el autowired
		
		return "vistas/alumnos/actualizarAlumnos";
	}
	
	// Borrar @GetMapping() @PostMapping()  @PostMapping()
	
	@GetMapping(value = "formularioeliminaralumno")
	public String HolaBorrar (ModelMap model) {
		return "vistas/alumnos/eliminarAlumnos";
	}
	
	@PostMapping(value = "formularioeliminaralumno")
	public String formularioBorrar(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre,
			ModelMap model) {
		
		List<AlumnoDTO> listaAlumnos = AlumnoRepo.buscarAlumnoporIDyNombre(id,nombre);
		model.addAttribute("lista", listaAlumnos);
		
		return "vistas/alumnos/eliminarAlumnos";
	}
	
	@PostMapping(value = "eliminaralumno")
	public String actualizarAlumno(
			@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {
		
	
		AlumnoRepo.deleteById(id); // inyectamos con el autowired
		
		return "vistas/alumnos/eliminarAlumnos";
	}
	
	

		
	



}
