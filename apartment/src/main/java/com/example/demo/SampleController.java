package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ApartmentDataInterface;
import com.example.demo.data.ApartmentDataService;

@RestController
public class SampleController {
	@Autowired
	ApartmentDataService service;
	
	@GetMapping("/apartment")
	@CrossOrigin
	public List<? extends ApartmentDataInterface> apartment() {
		System.out.println("apartment/index");
		return service.getAll();
	}
}
