package com.joffre.microservicios.app.usuarios.services.impl;

import org.springframework.stereotype.Service;

import com.joffre.microservicios.app.usuarios.repository.AlumnoRepository;
import com.joffre.microservicios.app.usuarios.services.AlumnoService;
import com.joffre.microservicios.commons.alumnos.models.entity.Alumno;
import com.joffre.microservicios.commons.services.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Override
	public int lastcode() {

		return repository.lastcode();
	}

}
