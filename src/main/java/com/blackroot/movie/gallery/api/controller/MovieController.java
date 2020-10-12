package com.blackroot.movie.gallery.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackroot.movie.gallery.api.service.MovieService;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public ResponseEntity<ServiceResponse> findAll() {
		return movieService.findAll();
	}

	@GetMapping(value = "/avaibility={avaibilityStatus}")
	public ResponseEntity<ServiceResponse> findByAvaibility(@PathVariable("avaibilityStatus") boolean avaibilityStatus,
			@PathParam("per_page") Integer per_page, @PathParam("page") Integer page) {
		return movieService.findByAvailabilityStatus(avaibilityStatus, page, per_page);
	}

	@GetMapping(value = "/avaibilityTrueForUser")
	public ResponseEntity<ServiceResponse> findByAvaibilityTrue(@PathParam("per_page") int per_page,
			@PathParam("page") int page) {
		return movieService.findByAvailabilityStatusTrue(page, per_page);
	}
}
