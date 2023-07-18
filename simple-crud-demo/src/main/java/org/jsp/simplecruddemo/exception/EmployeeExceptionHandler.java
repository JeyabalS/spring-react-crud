package org.jsp.simplecruddemo.exception;

import org.jsp.simplecruddemo.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> exceptionIdNotFoundHandler(IdNotFoundException e){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(e.getMessage());
		structure.setBody("Id Not Present");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> exceptionUserNotFoundHandler(UserNotFoundException e){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(e.getMessage());
		structure.setBody("User Not Present");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> exceptionInvalidCredentialsHandler(InvalidCredentialsException e){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(e.getMessage());
		structure.setBody("Invalid details");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
