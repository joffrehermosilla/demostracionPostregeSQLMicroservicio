package com.joffre.microservicios.app.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.joffre.microservicios.commons.alumnos.models.entity.Alumno;
import org.springframework.data.jpa.repository.Query;
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

	@Query(value = "select a.id from alumnos a order by id DESC LIMIT 1", nativeQuery = true)
	int lastcode();
}
