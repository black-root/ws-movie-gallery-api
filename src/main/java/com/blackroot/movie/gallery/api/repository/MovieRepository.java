package com.blackroot.movie.gallery.api.repository;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blackroot.movie.gallery.api.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	
	public Page<Movie> findByAvailabilityStatus(boolean avaibility, Pageable pageable);
	
	public Page<Movie> findAll(Pageable pageable);
	
	@Procedure(procedureName = "sp_UserLikesMovies")
	public Integer userLikesMovie(
			@Param("p_movie_id") int movieId,
			@Param("p_user_id") int userId);
	
	@Procedure(procedureName = "p_movieUpdated")
	public Integer movieUpdated(
			@Param("p_movie_id") int movieId,
			@Param("p_tittle") String tittle,
			@Param("p_rent_price") BigDecimal rentPrice,
			@Param("p_sale_price") BigDecimal salePrice);

}
