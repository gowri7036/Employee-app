package com.imaginn.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyEmployeeException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	public MyEmployeeException(String msg) {
		super(msg);
	}
}
