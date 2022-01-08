package com.joffre.microservicios.app.usuarios.services;

import java.util.Optional;

import com.joffre.microservicios.app.usuarios.entity.Alumno;

public interface AlumnoService {
	
	public Iterable<Alumno> findALl();
	
	public Optional<Alumno> findById(Long id);
	
    public Alumno save(Alumno alumno);
    
    public void deleteById(long id);
    
}
