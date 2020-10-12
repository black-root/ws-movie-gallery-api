package com.blackroot.movie.gallery.api.service;

import org.springframework.http.ResponseEntity;

import com.blackroot.movie.gallery.api.utils.ServiceResponse;

public interface MovieService {

	public abstract ResponseEntity<ServiceResponse> findAll();
	
	public abstract ResponseEntity<ServiceResponse> addMovie();
	
	public abstract ResponseEntity<ServiceResponse> deleteMovie();
	
	public abstract ResponseEntity<ServiceResponse> findByAvailabilityStatus(boolean avaibility);
	
	
}
