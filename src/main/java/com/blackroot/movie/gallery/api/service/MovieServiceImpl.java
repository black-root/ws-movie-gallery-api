package com.blackroot.movie.gallery.api.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blackroot.movie.gallery.api.dto.MovieRequest;
import com.blackroot.movie.gallery.api.entity.Movie;
import com.blackroot.movie.gallery.api.entity.MovieCategory;
import com.blackroot.movie.gallery.api.entity.PercentDiscount;
import com.blackroot.movie.gallery.api.entity.Rol;
import com.blackroot.movie.gallery.api.repository.MovieRepository;
import com.blackroot.movie.gallery.api.utils.JwtUtil;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@Service
public class MovieServiceImpl implements MovieService {

	private static Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private JwtUtil jwtUtil;

	/*
	 * @Autowired private ValidateService val;
	 * 
	 */
	@Override
	public ResponseEntity<ServiceResponse> findAll(Integer page, Integer per_page) {

		try {
			if (page != null || per_page != null) {
				Pageable sortedBytitle = PageRequest.of(page, per_page, Sort.by("tittle"));
				Page<Movie> movies = movieRepository.findAll(sortedBytitle);

				return new ResponseEntity<ServiceResponse>(
						new ServiceResponse(ServiceResponse.codeOk, ServiceResponse.messageOk, movies), HttpStatus.OK);
			} else {
				Pageable sortedBytitle = PageRequest.of(0, 10, Sort.by("tittle"));
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movieRepository.findAll(sortedBytitle)), HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error("Issue to find the data " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> addMovie(Movie movie) {
		Movie result = new Movie();
		try {
			// validateService.validator.validate(movie);
			log.info(movie.toString());
			result = movieRepository.save(movie);

			if (result != null) {
				return new ResponseEntity<ServiceResponse>(
						new ServiceResponse(ServiceResponse.codeOk, ServiceResponse.messageOk, result),
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ServiceResponse>(
						new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, result),
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error("Problems to process the request " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> deleteMovie(int idMovie) {
		try {
			movieRepository.deleteById(idMovie);
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeOk, ServiceResponse.messageOk, "Movie deleted"),
					HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Problems to process the request in order to delete a movie by ID " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail,
							"Id: " + idMovie + " doesn't exist, Consider to use a digit id"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> findByAvailabilityStatus(boolean avaibility, Integer page, Integer per_page,
			String jwt) {
		try {

			// val.validator.validate(avaibility);

			if (jwt == null || jwt.isEmpty())
				throw new IllegalArgumentException("El token no puede estar vacío!");
			Rol rol = jwtUtil.validateToken(jwt);

			// log.info(username.toString());
			if(!rol.getCode().equals("0001")) {
				return new ResponseEntity<ServiceResponse>(
						new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, "Only Admin can access, your rol is: "+rol.getName()),
						HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			}
			if (page != null || per_page != null) {
				Pageable sortedBytitle = PageRequest.of(page, per_page, Sort.by("tittle"));
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movieRepository.findByAvailabilityStatus(avaibility, sortedBytitle)),
						HttpStatus.OK);
			} else {
				Pageable sortedBytitle = PageRequest.of(0, 10, Sort.by("tittle"));
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movieRepository.findByAvailabilityStatus(true, sortedBytitle)),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error("Issue to find the data " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> findByAvailabilityStatusTrue(Integer page, Integer per_page) {
		try {

			if (page != null || per_page != null) {
				Pageable sortedBytitle = PageRequest.of(page, per_page, Sort.by("tittle"));
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movieRepository.findByAvailabilityStatus(true, sortedBytitle)),
						HttpStatus.OK);
			} else {
				Pageable sortedBytitle = PageRequest.of(0, 10, Sort.by("tittle"));
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movieRepository.findByAvailabilityStatus(true, sortedBytitle)),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error("Issue to find the data " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> modifyAvaibilityMovie(int id) {
		try {
			Movie movie = movieRepository.findById(id).get(), result;

			if (movie != null) {
				if (movie.getAvailabilityStatus() == false) {
					movie.setAvailability_status(true);
				} else {
					movie.setAvailability_status(false);
				}

				result = movieRepository.save(movie);
				return new ResponseEntity<ServiceResponse>(
						new ServiceResponse(ServiceResponse.codeOk, ServiceResponse.messageOk, result),
						HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, "Movie not found to change its status"), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Issue to find the data " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> userLikesMovie(int movieId, int userId) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
					ServiceResponse.messageOk, movieRepository.userLikesMovie(movieId, userId)), HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Issue to user likes a movie" + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional
	public ResponseEntity<ServiceResponse> updateMovie(MovieRequest movieRequest) {

		log.info(movieRequest.toString());
		Movie movie = new Movie();
		Movie movieLog;

		try {
			if (movieRequest.getId() > 0)
				movie = movieRepository.findById(movieRequest.getId()).get();
			movieLog = new Movie(movie);
			log.info(movieLog.getTittle());

		} catch (Exception e) {
			log.error("Error to find the movie with id: " + movieRequest.getId(), e);
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail,
							"Error to find the movie with id: " + movieRequest.getId() + "\n" + e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
		if (movie != null) {
			try {

				if (!movieRequest.getTittle().trim().isEmpty() && movieRequest.getTittle() != null)
					movie.setTittle(movieRequest.getTittle());
				log.info(movieLog.getTittle());
				if (movieRequest.getCategoryId() != null && movieRequest.getCategoryId() > 0)
					movie.setCategory(new MovieCategory(movieRequest.getCategoryId()));
				if (movieRequest.getSale_price() != null)
					movie.setSale_price(movieRequest.getSale_price());
				if (movieRequest.getRent_price() != null)
					movie.setRent_price(movieRequest.getRent_price());
				if (movieRequest.getPercent_discount_rent_price_id() != null
						&& movieRequest.getPercent_discount_rent_price_id() > 0) {
					movie.setPercent_discount_rent_price(
							new PercentDiscount(movieRequest.getPercent_discount_rent_price_id()));
				}
				if (movieRequest.getPercent_discount_sale_price_id() != null
						&& movieRequest.getPercent_discount_sale_price_id() > 0) {
					movie.setPercent_discount_sale_price(
							new PercentDiscount(movieRequest.getPercent_discount_sale_price_id()));
				}
				if (movieRequest.getStock() != null) {
					if (movieRequest.getStock() > 0)
						movie.setStock(movieRequest.getStock());
				}

				log.info(movieLog.toString());
				movie = movieRepository.save(movie);

				if (!movieLog.getTittle().equals(movie.getTittle())
						|| (!(movieLog.getSale_price().compareTo(movie.getSale_price()) == 0))
						|| (!(movieLog.getRent_price().compareTo(movie.getRent_price()) == 0))) {
					// log.info("old tittle "+movieLog.getTittle()+" new tittle"+movie.getTittle());
					// log.info("old sale price "+movieLog.getSale_price()+" new sale
					// price"+movie.getSale_price());
					movieRepository.movieUpdated(movieLog.getId(), movieLog.getTittle(), movieLog.getRent_price(),
							movieLog.getSale_price());

				}
				return new ResponseEntity<ServiceResponse>(
						new ServiceResponse(ServiceResponse.codeOk, ServiceResponse.messageOk, movie),
						HttpStatus.ACCEPTED);

			} catch (Exception e) {
				log.error("Error to update the movie with id: " + movieRequest.getId());
				return new ResponseEntity<ServiceResponse>(
						new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail,
								"Error to update the movie with id: " + movieRequest.getId() + "\n" + e.getMessage()),
						HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeFail,
					ServiceResponse.messageFail, "Error to update the movie with id: " + movieRequest.getId()),
					HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> findByTitle(String title, Integer page, Integer per_page) {
		try {

			if (page != null || per_page != null) {
				Pageable sortedBytitle = PageRequest.of(page, per_page, Sort.by("tittle"));
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movieRepository.findByTittleContaining(title, sortedBytitle)),
						HttpStatus.OK);
			} else {
				Pageable sortedBytitle = PageRequest.of(0, 10, Sort.by("tittle"));
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movieRepository.findByTittleContaining(title, sortedBytitle)),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error("Issue to find the data " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
