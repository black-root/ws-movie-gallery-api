package com.blackroot.movie.gallery.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blackroot.movie.gallery.api.repository.RolRepository;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public ResponseEntity<ServiceResponse> findAll() {
		
		try {
			return new ResponseEntity<ServiceResponse>(new ServiceResponse(
					ServiceResponse.codeOk, ServiceResponse.messageOk, rolRepository.findAll()), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<ServiceResponse>(new ServiceResponse(
					ServiceResponse.codeFail, ServiceResponse.messageFail, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
