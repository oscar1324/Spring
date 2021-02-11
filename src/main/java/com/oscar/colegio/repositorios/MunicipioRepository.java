package com.oscar.colegio.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;

import com.oscar.colegio.entities.MunicipiosEntity;


public interface MunicipioRepository extends CrudRepository<MunicipiosEntity, Integer>{

}
