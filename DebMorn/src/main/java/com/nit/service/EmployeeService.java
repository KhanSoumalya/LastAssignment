package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;
import com.nit.repo.EmployeeRepo;
import java.util.*;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo er;
	
	public void save(Employee e)
	{
		er.save(e);
	}
	
	public List<Employee> showAll()
	{
		return er.findAll();
	}
	
	public List<Employee> fifth(String str) {
		return er.search(str);
	}
	
	public Employee fifthHighest()
	{
		return er.fifth();
	}
	
	public List<Employee> faculty(String str)
	{
		return er.searchRole(str);
	}
	
	public int numbers(String str)
	{
		return er.countall(str);
	}

	public List<Employee> getterandsetter(String stri) {
		// TODO Auto-generated method stub
		return er.countalli(stri);
	}

}
