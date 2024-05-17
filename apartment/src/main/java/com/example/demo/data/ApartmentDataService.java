package com.example.demo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Apartment;
import com.example.demo.repositories.ApartmentRepository;

@Service
public class ApartmentDataService {
	@Autowired
	private ApartmentRepository repository;
	
	public List<? extends Apartment> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}
}
