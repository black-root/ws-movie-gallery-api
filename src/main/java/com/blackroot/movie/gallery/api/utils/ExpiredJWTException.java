package com.blackroot.movie.gallery.api.utils;

public class ExpiredJWTException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExpiredJWTException() {
		super("El token ha expirado!");
	}
	
	public ExpiredJWTException(String message) {
		super(message);
	}
}
