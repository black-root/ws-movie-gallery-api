package com.blackroot.movie.gallery.api.service;

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

import com.blackroot.movie.gallery.api.entity.Movie;
import com.blackroot.movie.gallery.api.repository.MovieRepository;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@Service
public class MovieServiceImpl implements MovieService {

	private static Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public ResponseEntity<ServiceResponse> findAll(Integer page, Integer per_page) {

		try {
			if (page != null || per_page != null) {
				Pageable sortedBytitle = PageRequest.of(page, per_page, Sort.by("tittle"));
				Page<Movie> movies = movieRepository.findAll(sortedBytitle);
			
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, movies), HttpStatus.OK);
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
		Movie result =  new Movie();
		try {
			//validateService.validator.validate(movie);
			log.info(movie.toString());
			result = movieRepository.save(movie);
			
			if(result!=null) {
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeOk,
						ServiceResponse.messageOk, result), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeFail,
						ServiceResponse.messageFail, result), HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			log.error("Problems to process the request "+e.getMessage());
			return new ResponseEntity<ServiceResponse>(new ServiceResponse(ServiceResponse.codeFail,
					ServiceResponse.messageFail, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> deleteMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ServiceResponse> findByAvailabilityStatus(boolean avaibility, Integer page,
			Integer per_page) {
		try {
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
}
