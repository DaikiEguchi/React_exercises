package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ApartmentDataInterface;
import com.example.demo.data.ApartmentDataService;
import com.example.demo.model.Apartment;

@RestController
public class SampleController {
	@Autowired
	ApartmentDataService service;
	
	// 一覧取得
	@GetMapping("/apartment")
	@CrossOrigin
	public List<? extends ApartmentDataInterface> apartment() {
		System.out.println("apartment/index");
		return service.getAll();
	}

	// 情報取得
	@GetMapping("/apartment/{id}")
	@CrossOrigin
	public ApartmentDataInterface apartmentById(@PathVariable int id) {
		System.out.println("apartment/findById");
		return service.getById(id);
	}
	
	// 追加
	@PostMapping("/apartment/add")
	@CrossOrigin
	public int add(@RequestBody Apartment apartment) {
		System.out.println("apartment/add(post)");
		return service.add(apartment);
	}

	// 更新
	@PostMapping("/apartment/update")
	@CrossOrigin
	public int update(@RequestBody Apartment apartment) {
		System.out.println("apartment/update(post)");
		return service.add(apartment);
	}

	// 削除
	@PostMapping("/apartment/delete")
	@CrossOrigin
	public void delete(@RequestBody Apartment apartment) {
		System.out.println("apartment/delete(post)");
		service.delete(apartment);
	}
}
