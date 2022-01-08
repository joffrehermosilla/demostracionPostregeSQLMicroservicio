package com.joffre.microservicios.app.usuarios.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joffre.microservicios.app.usuarios.entity.Alumno;
import com.joffre.microservicios.app.usuarios.repository.AlumnoRepository;
import com.joffre.microservicios.app.usuarios.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findALl() {

		return alumnoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(Long id) {

		return alumnoRepository.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {

		return alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(long id) {

		alumnoRepository.deleteById(id);
	}

}
