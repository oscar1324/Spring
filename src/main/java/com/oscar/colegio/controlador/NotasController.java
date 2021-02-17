package com.oscar.colegio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.colegio.dao.CombosDAO;
import com.oscar.colegio.dao.NotasDAO;
import com.oscar.colegio.dao.impl.NotasDAOImpl;
import com.oscar.colegio.dtos.NotaDTO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.entities.NotaEntity;
import com.oscar.colegio.repositorios.AlumnoRepository;
import com.oscar.colegio.repositorios.AsignaturaRepository;
import com.oscar.colegio.repositorios.NotasRepository;

@Controller
public class NotasController {

	@Autowired
	private AlumnoRepository AlumnoR;
	
	@Autowired
	private AsignaturaRepository AsigR;
	
	@Autowired
	private NotasDAO NotaImpl;
	
	@Autowired
	private NotasRepository NotaR;
	
	@Autowired
	private CombosDAO cc;
	
	// INSERTAR -------------------------------------------------------------------------------------------------
	@GetMapping(value ="insertarnota")
	public String FormularioInsertar(ModelMap model) {
		model.addAttribute("listaAlumnos",cc.comboAlumnos());
		model.addAttribute("listaAsignaturas",cc.comboAsignaturas());
		return "vistas/notas/insertarNotas";
	}
	
	@PostMapping(value ="insertarnota")
	public String Insertarnota(
			@RequestParam(value = "alumnos", required = false) Integer idAlumno,
			@RequestParam(value = "asignaturas", required = false) Integer idAsignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model) {
		
		model.addAttribute("resultado", NotaImpl.insertarNota(idAlumno, idAsignatura, nota, fecha));

		return "vistas/notas/insertarNotas";
	}
	
	
	// LISTAR -------------------------------------------------------------------------------------------------
	
	@GetMapping(value ="listadonotas")
	public String formularioListar(ModelMap model) {
		return "vistas/notas/listadoNotas";
	}
	
	@PostMapping(value = "listadonotas")
	public String listadonotas(
			@RequestParam(value = "id", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String idasignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model) {


		model.addAttribute("lista", NotaImpl.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombreAlumno, idasignatura, nota, fecha));

		return "vistas/notas/listadoNotas";
	}
	// ACTUALIZAR -------------------------------------------------------------------------------------------------
	@GetMapping(value ="formularioactualizarnota")
	public String FormularioActualizar(ModelMap model) {

		return "vistas/notas/actualizarNotas";
	}
	
	@PostMapping(value = "formularioactualizarnota")
	public String formularioModificarnotas(
			@RequestParam(value = "id",required = false) Integer id,
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model) {

		List<NotaDTO> listaNotas = NotaR.buscarPorAlumnoAsignaturaNotaFecha(id, alumno, asignatura, null,fecha);
		model.addAttribute("comboAlumnos", cc.comboAlumnos());
		model.addAttribute("comboAsignaturas", cc.comboAsignaturas());
		
		model.addAttribute("lista", listaNotas);

		return "vistas/notas/actualizarNotas";
	}
	
	@PostMapping(value= "actualizarnota")
	public String modificarNota(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "alumnos", required = false) Integer alumno,
			@RequestParam(value = "asignaturas", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		AlumnoEntity alumnoEntity = AlumnoR.findById(alumno).get();
		AsignaturasEntity asignaturasEntity = AsigR.findById(asignatura).get();
		
		NotaEntity notas = new NotaEntity(alumnoEntity, asignaturasEntity, nota, fecha, id);

		NotaR.save(notas);
		
		return  "vistas/notas/actualizarNotas";
	}
	
	
	// BORRAR -------------------------------------------------------------------------------------------------
	@GetMapping(value= "formularioborrarnota")
	public String FormularioBorrar(ModelMap model) {
		return "vistas/notas/borrarNotas";
	}
	
	@PostMapping(value = "formularioborrarnota")
	public String formularioBorrarnotas(
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model) {

		List<NotaDTO> listaNotas = NotaR.buscarPorAlumnoAsignaturaNotaFecha(null, alumno, asignatura, null,fecha);

		model.addAttribute("lista", listaNotas);

		return "vistas/notas/borrarNotas";
	}
	
	@PostMapping(value = "borrarnota")
	public String borrarnota(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "tasa", required = false) Double tasa,
			@RequestParam(value = "curso", required = false) Integer curso, ModelMap model) {

		NotaR.deleteById(id);

		return "vistas/notas/borrarNotas";
	}
}
