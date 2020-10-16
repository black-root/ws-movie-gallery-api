package com.blackroot.movie.gallery.api.service;

import javax.validation.Validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateService {
	//@Autowired 
	Validator validator;

	
	public void validate(Object validateObject){
		Set<ConstraintViolation<Object>> violations = validator.validate(validateObject);
		
		String result = violations.stream().map(violation -> violation.getMessage()).reduce("", (initial, element) -> initial + element + "\n");
		
		if(!violations.isEmpty()) {
			throw new IllegalArgumentException(result);
		}
	}
}
