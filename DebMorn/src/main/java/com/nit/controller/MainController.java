package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Employee;
import com.nit.service.EmployeeService;
import java.util.*;

@RestController
public class MainController {
	
	@Autowired
	private EmployeeService es;
	
	
	@PostMapping("/save")
	public void save(@RequestBody Employee ert)
	{
		es.save(ert);
	}
	
	@GetMapping("/show")
	public List<Employee> show(){
		return es.showAll();
	}
	
	
	@GetMapping("/fifth/{searchkey}")
	@ResponseBody
	public List<Employee> fifth(@PathVariable String searchkey) {
		return es.fifth(searchkey);
	}

	@PostMapping("/fifthhigh")
	public Employee fifthHigh()
	{
		return es.fifthHighest();
	}
	
	@GetMapping("/searching/{key}")
	@ResponseBody
	public List<Employee> fifthil(@PathVariable String key) {
		return es.faculty(key);
	}
	
	@GetMapping("/count/{str}")
	@ResponseBody
	public ResponseEntity<String> countnumbers(@PathVariable String str){
		int srt=es.numbers(str);
		String stri="The number of employees from :: "+str+"  is  "+srt;
		return new ResponseEntity<>(stri,HttpStatus.OK);
	}
	
	
	@GetMapping("/visible/{str}")
	@ResponseBody
	public ResponseEntity<?> visible(@PathVariable String str){
		
			List<Employee> ls=new ArrayList<>();
			ls=es.getterandsetter(str);
			if(!ls.isEmpty())
			{
		return new ResponseEntity<>(ls,HttpStatus.OK);
		}
			else{
			return new ResponseEntity<>("Not Found Such Entity",HttpStatus.NOT_FOUND);
		}
	}
	
	
}
