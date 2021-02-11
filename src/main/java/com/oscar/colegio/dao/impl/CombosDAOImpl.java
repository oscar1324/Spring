package com.oscar.colegio.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.colegio.dao.CombosDAO;
import com.oscar.colegio.dtos.ComboDTO;
import com.oscar.colegio.entities.MunicipiosEntity;
import com.oscar.colegio.repositorios.MunicipioRepository;

@Service
public class CombosDAOImpl implements CombosDAO{
	@Autowired 
	private MunicipioRepository municipioRepository;
	
	@Override
	public List<ComboDTO> comboMunicipios() {
		Iterable<MunicipiosEntity> listaEntidadesMunicipios = municipioRepository.findAll(); //
		List<ComboDTO> listaMunicipios = mapeoEntidadesMunicipioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<ComboDTO> mapeoEntidadesMunicipioComboDTO(Iterable<MunicipiosEntity> listaEntidadesMunicipios){
		List<ComboDTO> listaMunicipios = new ArrayList<ComboDTO>();
		
		for(MunicipiosEntity m : listaEntidadesMunicipios) {
			listaMunicipios.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		return listaMunicipios;
	}
	

}
