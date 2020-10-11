package com.blackroot.movie.gallery.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.blackroot.movie.gallery.api.repository.UserRepository;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<ServiceResponse> findAll() {
		
		try {
			return new ResponseEntity<ServiceResponse>(new ServiceResponse(
					ServiceResponse.codeOk, ServiceResponse.messageOk, userRepository.findAll()), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Issue to find All data "+e.getMessage());
			return new ResponseEntity<ServiceResponse>(new ServiceResponse(
					ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
