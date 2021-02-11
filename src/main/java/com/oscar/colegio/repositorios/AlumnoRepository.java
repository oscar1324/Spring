package com.oscar.colegio.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.oscar.colegio.entities.AlumnoEntity;
import com.oscar.colegio.entities.MunicipiosEntity;

public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Integer>{

}
