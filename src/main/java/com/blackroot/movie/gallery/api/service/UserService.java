package com.blackroot.movie.gallery.api.service;

import org.springframework.http.ResponseEntity;

import com.blackroot.movie.gallery.api.utils.ServiceResponse;

public interface UserService {

	public abstract ResponseEntity<ServiceResponse> findAll();
}
