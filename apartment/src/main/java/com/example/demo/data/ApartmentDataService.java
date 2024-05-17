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
	
	public Apartment getById(int id) {
		System.out.println("Service:getById id[" + id + "]");
		return repository.findById(id).orElse(null);
	}

	public int add(ApartmentDataInterface item) {
		System.out.println("Service:add [" + item + "]");
		if (item instanceof Apartment) {
			Apartment savedItem = repository.saveAndFlush((Apartment)item);
			return savedItem.getId();
		}
		return 0;
	}
	
	public void delete(ApartmentDataInterface item) {
		System.out.println("Service:delete[" + item + "]");
		if (item instanceof Apartment) {
			repository.delete((Apartment) item);
		}
	}
}
