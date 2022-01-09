package com.joffre.microservicios.app.usuarios.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.joffre.microservicios.app.usuarios.services.AlumnoService;
import com.joffre.microservicios.commons.alumnos.models.entity.Alumno;
import com.joffre.microservicios.commons.controllers.CommonController;
import com.joffre.microservicios.commons.utileria.Utileria;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Alumno> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Alumno alumnoDb = o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));

	}

	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid Alumno alumno, BindingResult result, @PathVariable Long id,
			@RequestParam MultipartFile archivo) throws IOException {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Alumno> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Alumno alumnoDb = o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		if (!archivo.isEmpty()) {
			alumnoDb.setFoto(archivo.getBytes());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));

	}

	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> crearConFoto(@Valid Alumno alumno, BindingResult result,
			@RequestParam MultipartFile archivo, HttpServletRequest request) throws IOException {
		// TODO Auto-generated method stub

		if (!archivo.isEmpty()) {
			alumno.setFoto(archivo.getBytes());
		}

		return super.crear(alumno, result);
	}
	@PostMapping("/crear-con-fotoruta")
	public ResponseEntity<?> crearConFotoRuta(@Valid Alumno alumno, BindingResult result,
			@RequestParam MultipartFile archivo, HttpServletRequest request) throws IOException {

		int totalusuario = service.lastcode() + 1;

		if (!archivo.isEmpty()) {
			// usuario.setFoto(archivo.getBytes());

			String rutax = "/resources/images/usuarios/" + totalusuario;
			System.out.println("rutax: " + rutax);
			String nombreImagen = Utileria.guardarImagenPlus(archivo, request, rutax);

			alumno.setRutafoto(nombreImagen);

		}

		return super.crear(alumno, result);
	}

}
