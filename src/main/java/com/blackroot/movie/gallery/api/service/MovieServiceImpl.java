package com.blackroot.movie.gallery.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blackroot.movie.gallery.api.repository.MovieRepository;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@Service
public class MovieServiceImpl implements MovieService {

	private static Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public ResponseEntity<ServiceResponse> findAll() {

		try {
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeOk, ServiceResponse.messageOk, movieRepository.findAll()),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Issue to find All data " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ServiceResponse> addMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ServiceResponse> deleteMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ServiceResponse> findByAvailabilityStatus(boolean avaibility) {
		try {
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeOk, ServiceResponse.messageOk, movieRepository.findByAvailabilityStatus(avaibility)),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Issue to find All data " + e.getMessage());
			return new ResponseEntity<ServiceResponse>(
					new ServiceResponse(ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
