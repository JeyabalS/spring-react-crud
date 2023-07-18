package org.jsp.simplecruddemo.dao;

import java.util.Optional;

import org.jsp.simplecruddemo.dto.Employee;
import org.jsp.simplecruddemo.repository.EmployeeRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepositoy repository;
	
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
		return repository.save(emp);
	}
	
	public Optional<Employee> findEmpById(int id){
		return repository.findById(id);
	}
	
	public void deleteEmp(int id) {
		repository.deleteById(id);
	}
	
	public Optional<Employee> verifyPhone(long phone,String password){
		return repository.verifyPhone(phone, password);
	}
	
	public Optional<Employee> verifyId(int id,String password){
		return repository.verifyId(id, password);
	}
	
	public Optional<Employee> findEmpByDesg(String desg){
		return repository.findByDesg(desg);
	}
	
	public Optional<Employee> findEmpByDept(String dept){
		return repository.findByDept(dept);
	}
}
