package com.oscar.colegio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.colegio.dao.CombosDAO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.entities.NotaEntity;
import com.oscar.colegio.repositorios.NotasRepository;

@Controller
public class NotasController {

	@Autowired
	private NotasRepository NT;
	
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
	public String InsertarNotas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("alumnos") Integer idalumnos,
			@RequestParam("asignatura")Integer idasignaturas,
			@RequestParam(value ="nota")Double nota,
			@RequestParam("fecha")String fecha) {
		

		//NotaEntity notas = new NotaEntity(id, idalumnos, idasignaturas, nota, fecha);
		//NT.save(notas);
		return "vistas/notas/insertarNotas";
	}
	
	
	// LISTAR -------------------------------------------------------------------------------------------------
	
	@GetMapping(value ="listadonotas")
	public String formularioListar(ModelMap model) {
		return "vistas/notas/listadoNotas";
	}
	// ACTUALIZAR -------------------------------------------------------------------------------------------------
	@GetMapping(value ="formularioactualizarnota")
	public String FormularioActualizar(ModelMap model) {
		model.addAttribute("listaAlumnos", cc.comboAlumnos());
		model.addAttribute("listaAsignaturas", cc.comboAsignaturas());
		return "vistas/notas/insertarNotas";
	}
	
	// BORRAR -------------------------------------------------------------------------------------------------
	@GetMapping(value= "borrarnota")
	public String FormularioBorrar(ModelMap model) {
		return "vistas/notas/borrarNotas";
	}
}
