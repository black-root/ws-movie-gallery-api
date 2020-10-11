package com.blackroot.movie.gallery.api.service;

import org.springframework.http.ResponseEntity;

import com.blackroot.movie.gallery.api.utils.ServiceResponse;


public interface RolService {
	
	public abstract ResponseEntity<ServiceResponse> findAll();
}
