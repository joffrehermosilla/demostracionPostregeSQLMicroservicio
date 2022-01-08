package com.joffre.microservicios.app.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.joffre.microservicios.commonsalumnos.models.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

}
