package org.jsp.simplecruddemo.exception;

public class IdNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Id Not Found";
	}
}
