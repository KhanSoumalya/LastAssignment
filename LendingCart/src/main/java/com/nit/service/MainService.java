package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.ClassNumber;
import com.nit.repository.MainRepo;
import java.util.*;

@Service
public class MainService {
	
	@Autowired
	private MainRepo mr;
	
	public List<ClassNumber> show()
	{
		return mr.findAll();
	}

	
	public void save(ClassNumber cn)
	{
		mr.save(cn);
	}
}
