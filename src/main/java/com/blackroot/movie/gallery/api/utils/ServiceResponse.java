package com.blackroot.movie.gallery.api.utils;

import org.springframework.boot.info.BuildProperties;

public class ServiceResponse {

	
	private String code;
	
	private String message;
	
	private Object result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public ServiceResponse(String code, String message, Object result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public ServiceResponse() {
		super();
	}
	
	
}
