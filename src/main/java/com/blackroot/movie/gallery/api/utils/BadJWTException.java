package com.blackroot.movie.gallery.api.utils;

public class BadJWTException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BadJWTException(String message) {
		super(message);
	}
}
