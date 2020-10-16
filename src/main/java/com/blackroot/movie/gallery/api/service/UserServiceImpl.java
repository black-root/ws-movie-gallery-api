package com.blackroot.movie.gallery.api.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blackroot.movie.gallery.api.entity.Usuario;
import com.blackroot.movie.gallery.api.repository.UserRepository;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@Service
public class UserServiceImpl implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


	@Autowired
	private UserRepository userRepository;
	
	
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = userRepository.findByEmail(email);
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
}
