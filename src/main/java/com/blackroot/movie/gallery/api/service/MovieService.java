package com.blackroot.movie.gallery.api.service;

import org.springframework.http.ResponseEntity;

import com.blackroot.movie.gallery.api.dto.MovieRequest;
import com.blackroot.movie.gallery.api.entity.Movie;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

public interface MovieService {

	public abstract ResponseEntity<ServiceResponse> findAll(Integer page,
			Integer per_page);
	
	public abstract ResponseEntity<ServiceResponse> addMovie(Movie movie, String jwt);
	
	public abstract ResponseEntity<ServiceResponse> deleteMovie(int idMovie, String jwt);
	
	public abstract ResponseEntity<ServiceResponse> findByAvailabilityStatus(boolean avaibility, Integer page, Integer per_page,
			String jwt);

	public abstract ResponseEntity<ServiceResponse> findByAvailabilityStatusTrue(Integer page, Integer per_page, String jwt);

	public abstract ResponseEntity<ServiceResponse> modifyAvaibilityMovie(int id, String jwt);
	
	public abstract ResponseEntity<ServiceResponse> userLikesMovie(int movieId, int userId, String jwt);

	public abstract ResponseEntity<ServiceResponse> updateMovie(MovieRequest movie, String jwt);

	public abstract ResponseEntity<ServiceResponse> findByTitle(String title, Integer page, Integer per_page);
	
}
