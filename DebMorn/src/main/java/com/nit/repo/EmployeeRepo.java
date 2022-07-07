package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.nit.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query(value = "select * from employee order by salary ASC limit %?1%,1",nativeQuery = true)
	List<Employee> search(String inputString);
	
	
	@Query(value = "select * from employee order by salary ASC limit 5,1",nativeQuery = true)
	Employee fifth();
	
	@Query(value = "select * from employee where job like %?1%",nativeQuery = true)
	List<Employee> searchRole(String fac);
	
	@Query(value="select count(*) from address where address_line_1 = :ct",nativeQuery = true)
	public int countall(String ct);
	
	@Query(value="select * from employee right join address on address.id=employee.adr_id where address.address_line_1 = :qt",nativeQuery = true)
	public List<Employee> countalli(String qt);
	
	
	
}
