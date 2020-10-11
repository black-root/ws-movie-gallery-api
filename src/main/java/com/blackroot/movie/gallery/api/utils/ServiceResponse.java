package com.blackroot.movie.gallery.api.utils;

public class ServiceResponse {

	public static final String codeOk = "00";
	public static final String messageOk = "Request proccesed satisfactorily";
	
	public static  final String codeFail = "99";
	public static final String messageFail = "Request failed";

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
