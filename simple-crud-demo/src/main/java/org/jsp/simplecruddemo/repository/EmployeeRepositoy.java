package org.jsp.simplecruddemo.repository;

import java.util.Optional;

import org.jsp.simplecruddemo.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepositoy extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.phone=?1 and e.password=?2")
	public Optional<Employee> verifyPhone(long phone,String password);
	
	@Query("select e from Employee e where e.id=?1 and e.password=?2")
	public Optional<Employee> verifyId(int id,String password);
	
	@Query("select e from Employee e where e.desg=?1")
	public Optional<Employee> findByDesg(String desg);
	
	@Query("select e from Employee e where e.dept=?1")
	public Optional<Employee> findByDept(String dept);
}
