package com.joffre.microservicios.commons.services;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface CommonService<E> {
	
public Iterable<E> findAll();
	
	public Page<E> findAll(Pageable pageable);
	
	public Optional<E> findById(Long id);
	
    public E save(E entity);
    
    public void deleteById(long id);
    
}
