package org.jsp.simplecruddemo.exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid credentials";
	}
}
