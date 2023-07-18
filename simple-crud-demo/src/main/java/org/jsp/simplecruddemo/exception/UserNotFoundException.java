package org.jsp.simplecruddemo.exception;

public class UserNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "User Not Found";
	}
}
