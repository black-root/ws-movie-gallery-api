package com.blackroot.movie.gallery.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blackroot.movie.gallery.api.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	public List<Movie> findByAvailabilityStatus(boolean avaibility);
}
