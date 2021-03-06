package com.blackroot.movie.gallery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackroot.movie.gallery.api.service.RolServiceImpl;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@RestController
@RequestMapping(value = "rols")
public class RolController {

	@Autowired
	private RolServiceImpl rolServiceImpl;
	
	@GetMapping
	public ResponseEntity<ServiceResponse> findAll(){
		return rolServiceImpl.findAll();
	}
}
