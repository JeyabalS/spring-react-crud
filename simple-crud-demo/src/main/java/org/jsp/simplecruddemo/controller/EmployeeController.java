package org.jsp.simplecruddemo.controller;

import org.jsp.simplecruddemo.dto.Employee;
import org.jsp.simplecruddemo.dto.ResponseStructure;
import org.jsp.simplecruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> saveEmp(@RequestBody Employee emp){
		return service.saveEmp(emp);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> updateEmp(@RequestBody Employee emp){
		return service.updateEmp(emp);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findEmpById(@PathVariable int id){
		return service.findEmpById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmpById(@PathVariable int id){
		return service.deleteEmpById(id);
	}
	
	@PostMapping("/employees/find-desg/{desg}")
	public ResponseEntity<ResponseStructure<Employee>> findEmpByDesg(@PathVariable String desg){
		return service.findEmpByDesg(desg);
	}
	
	@PostMapping("/employees/find-dept/{dept}")
	public ResponseEntity<ResponseStructure<Employee>> findEmpByDept(@PathVariable String dept){
		return service.findEmpByDept(dept);
	}
	
	@PostMapping("/employees/verify-phone")
	public ResponseEntity<ResponseStructure<Employee>> verifyPhone(@RequestParam long phone,@RequestParam String password){
		return service.verifyByPhone(phone, password);
	}
	
	@PostMapping("/employees/verify-id")
	public ResponseEntity<ResponseStructure<Employee>> verifyId(@RequestParam int id,@RequestParam String password){
		return service.verifyById(id, password);
	}
}
