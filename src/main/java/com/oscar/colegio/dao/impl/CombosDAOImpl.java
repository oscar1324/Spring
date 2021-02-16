package com.oscar.colegio.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.colegio.dao.CombosDAO;
import com.oscar.colegio.dtos.AlumnoDTO;
import com.oscar.colegio.dtos.ComboDTO;
import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.AsignaturasEntity;
import com.oscar.colegio.entities.MunicipiosEntity;
import com.oscar.colegio.repositorios.AlumnoRepository;
import com.oscar.colegio.repositorios.AsignaturaRepository;
import com.oscar.colegio.repositorios.MunicipioRepository;

@Service
public class CombosDAOImpl implements CombosDAO{
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AsignaturaRepository AR;
	@Override
	public List<ComboDTO> comboMunicipios() {
		Iterable<MunicipiosEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		List<ComboDTO> listaMunicipios = mapeoEntidadMunicipioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {
		Iterable<AlumnoEntity> listaEntidadesAlumnos = alumnoRepository.findAll();
		List<ComboDTO> listaAlumnos = mapeoEntidadAlumnoComboDTO(listaEntidadesAlumnos);
		return listaAlumnos;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		Iterable<AsignaturasEntity> listaEntidadesAsignaturas = AR.findAll();
		List<ComboDTO> listaAsignaturas = mapeoEntidadAsignaturaComboDTO(listaEntidadesAsignaturas);
		return listaAsignaturas;
	}
	
//	------------------------------------------------------------------------------------------------------------------
	private List<ComboDTO> mapeoEntidadMunicipioComboDTO(Iterable<MunicipiosEntity> listaEntidadesMunicipios){
		List<ComboDTO> listaMunicipios = new ArrayList<ComboDTO>();
		for(MunicipiosEntity m: listaEntidadesMunicipios) {
			listaMunicipios.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		return listaMunicipios;
	}
	
	private List<ComboDTO> mapeoEntidadAlumnoComboDTO(Iterable<AlumnoEntity> listaEntidadesAlumnos){
		List<ComboDTO> listaAlumnos = new ArrayList<ComboDTO>();
		for(AlumnoEntity m: listaEntidadesAlumnos) {
			listaAlumnos.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		return listaAlumnos;
	}

	
	private List<ComboDTO> mapeoEntidadAsignaturaComboDTO(Iterable<AsignaturasEntity> listaEntidadesAsignaturas){
		List<ComboDTO> listaAsignaturas = new ArrayList<ComboDTO>();
		for(AsignaturasEntity m: listaEntidadesAsignaturas) {
			listaAsignaturas.add(new ComboDTO(m.getId(), m.getnombre()));
		}
		return listaAsignaturas;
	}

}
