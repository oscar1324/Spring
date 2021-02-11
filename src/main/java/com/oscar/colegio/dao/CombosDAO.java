package com.oscar.colegio.dao;

import java.util.List;

import com.oscar.colegio.dtos.ComboDTO;

public interface CombosDAO {
	List<ComboDTO> comboMunicipios();
	List<ComboDTO> comboAlumnos();
	List<ComboDTO> comboAsignaturas();
}
