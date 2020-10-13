package com.blackroot.movie.gallery.api.service;

import org.springframework.http.ResponseEntity;

import com.blackroot.movie.gallery.api.entity.Movie;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

public interface MovieService {

	public abstract ResponseEntity<ServiceResponse> findAll(Integer page,
			Integer per_page);
	
	public abstract ResponseEntity<ServiceResponse> addMovie(Movie movie);
	
	public abstract ResponseEntity<ServiceResponse> deleteMovie();
	
	public abstract ResponseEntity<ServiceResponse> findByAvailabilityStatus(boolean avaibility, Integer page, Integer per_page);

	public abstract ResponseEntity<ServiceResponse> findByAvailabilityStatusTrue(Integer page, Integer per_page);
	
	
}
