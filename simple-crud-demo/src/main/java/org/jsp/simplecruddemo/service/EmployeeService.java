package org.jsp.simplecruddemo.service;

import java.util.Optional;

import org.jsp.simplecruddemo.dao.EmployeeDao;
import org.jsp.simplecruddemo.dto.Employee;
import org.jsp.simplecruddemo.dto.ResponseStructure;
import org.jsp.simplecruddemo.exception.IdNotFoundException;
import org.jsp.simplecruddemo.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmp(Employee emp){
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setMessage("Employee Registered successfull");
		structure.setCode(HttpStatus.CREATED.value());
		structure.setBody(dao.saveEmployee(emp));
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmp(Employee emp){
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setMessage("Employee Updated successfull");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.updateEmployee(emp));
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmpById(int id){
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		Optional<Employee> recEmp = dao.findEmpById(id);
		if(recEmp.isPresent()) {
			structure.setBody(recEmp.get());
			structure.setMessage("User found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEmpById(int id){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Optional<Employee> recEmp = dao.findEmpById(id);
		if(recEmp.isPresent()) {
			dao.deleteEmp(id);
			structure.setBody("User found");
			structure.setMessage("User deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setBody("User not found");
		structure.setMessage("User not deleted");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> verifyByPhone(long phone,String password){
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		Optional<Employee> recEmp = dao.verifyPhone(phone, password);
		if(recEmp.isPresent()) {
			structure.setBody(recEmp.get());
			structure.setMessage("Verification successfull");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> verifyById(int id,String password){
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		Optional<Employee> recEmp = dao.verifyId(id, password);
		if(recEmp.isPresent()) {
			structure.setBody(recEmp.get());
			structure.setMessage("Verification successfull");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmpByDesg(String desg){
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		Optional<Employee> recEmp = dao.findEmpByDesg(desg);
		if(recEmp.isPresent()) {
			structure.setBody(recEmp.get());
			structure.setMessage("User found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmpByDept(String dept){
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		Optional<Employee> recEmp = dao.findEmpByDept(dept);
		if(recEmp.isPresent()) {
			structure.setBody(recEmp.get());
			structure.setMessage("User found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
}
