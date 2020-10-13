package com.blackroot.movie.gallery.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blackroot.movie.gallery.api.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	
	public Page<Movie> findByAvailabilityStatus(boolean avaibility, Pageable pageable);
	
	public Page<Movie> findAll(Pageable pageable);

}
