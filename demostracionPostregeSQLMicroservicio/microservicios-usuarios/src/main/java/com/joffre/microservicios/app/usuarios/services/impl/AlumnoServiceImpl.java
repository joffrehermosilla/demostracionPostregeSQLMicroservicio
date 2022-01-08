package com.joffre.microservicios.app.usuarios.services.impl;

import org.springframework.stereotype.Service;

import com.joffre.microservicios.app.usuarios.repository.AlumnoRepository;
import com.joffre.microservicios.app.usuarios.services.AlumnoService;
import com.joffre.microservicios.commons.services.CommonServiceImpl;
import com.joffre.microservicios.commonsalumnos.models.entity.Alumno;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,AlumnoRepository> implements AlumnoService {

}
