package com.blackroot.movie.gallery.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackroot.movie.gallery.api.dto.MovieRequest;
import com.blackroot.movie.gallery.api.entity.Movie;
import com.blackroot.movie.gallery.api.service.MovieService;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public ResponseEntity<ServiceResponse> findAll(@PathParam("page")Integer page,
			@PathParam("per_page") Integer per_page) {
		return movieService.findAll(page, per_page);
	}

	@GetMapping(value = "/avaibility={avaibilityStatus}")
	public ResponseEntity<ServiceResponse> findByAvaibility(
			@PathVariable("avaibilityStatus") boolean avaibilityStatus,
			@PathParam("per_page") Integer per_page, @PathParam("page") Integer page,
			@RequestHeader(value = "Authorization", required = false)  String jwt) {
		return movieService.findByAvailabilityStatus(avaibilityStatus, page, per_page, jwt);
	}

	@GetMapping(value = "/avaibilityTrueForUser")
	public ResponseEntity<ServiceResponse> findByAvaibilityTrue(@PathParam("per_page") Integer per_page,
			@PathParam("page") Integer page, @RequestHeader(value = "Authorization", required = false) String jwt) {
		return movieService.findByAvailabilityStatusTrue(page, per_page, jwt);
	}
	
	@GetMapping(value = "/findByTitle/{title}")
	public ResponseEntity<ServiceResponse> findByTitle(@PathVariable("title") String title,
			@PathParam("per_page") Integer per_page,
			@PathParam("page") Integer page) {
		return movieService.findByTitle(title,page, per_page);
	}
	
	@PostMapping
	public ResponseEntity<ServiceResponse> addMovie(@RequestBody Movie movie,
			@RequestHeader(value = "Authorization", required = false)  String jwt){
		return movieService.addMovie(movie, jwt);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> deleteMovieById(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = false)  String jwt){
		return movieService.deleteMovie(id, jwt);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> modifyAvaibilityMovie(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = false)  String jwt){
		return movieService.modifyAvaibilityMovie(id, jwt);
	}
	
	@PostMapping(value = "/movieId={movieId}&userId={userId}")
	public ResponseEntity<ServiceResponse> userLikesMovie(@PathVariable("movieId") int movieId,
			@PathVariable("userId") int userId,
			@RequestHeader(value = "Authorization", required = false)  String jwt){
		return movieService.userLikesMovie(movieId, userId, jwt);
	}
	
	@PutMapping
	public ResponseEntity<ServiceResponse> updateMovie(@RequestBody MovieRequest movie,
			@RequestHeader(value = "Authorization", required = false)  String jwt){
		return movieService.updateMovie(movie, jwt);	
	}
}
