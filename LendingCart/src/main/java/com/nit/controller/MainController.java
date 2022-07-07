package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.ClassNumber;
import com.nit.service.MainService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MainController {
	
	
	
	@Autowired
	private MainService ms;
	
	@GetMapping("/class/show")
	public List<ClassNumber>  showDetails()
	{
		return ms.show();
	}
	
	@PostMapping("/class")
	public ResponseEntity<?> save(@RequestBody ClassNumber ct)
	{
		try {
			ms.save(ct);
			return new ResponseEntity<ClassNumber>(ct,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<String>("Unable to save",HttpStatus.NOT_MODIFIED);
		}
	}
	
	

}
