package com.joffre.microservicios.app.usuarios.services;

import com.joffre.microservicios.commons.alumnos.models.entity.Alumno;
import com.joffre.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno> {
	int lastcode();
}
