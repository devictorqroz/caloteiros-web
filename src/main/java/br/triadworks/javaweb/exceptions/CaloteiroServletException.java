package br.triadworks.javaweb.exceptions;

import jakarta.servlet.ServletException;

public class CaloteiroServletException extends ServletException {

	public CaloteiroServletException() {
		super();
	}
	
	public CaloteiroServletException(String message) {
		super(message);
	}
	
}
