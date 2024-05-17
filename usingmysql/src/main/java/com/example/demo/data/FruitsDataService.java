package com.example.demo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fruit;
import com.example.demo.repositories.FruitsRepository;

@Service
public class FruitsDataService {
	@Autowired
	private FruitsRepository repository;
	
	public List<? extends FruitsDataInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}
	
	public FruitsDataInterface getById(int id) {
		System.out.println("Service:getById id[" + id + "]");
		return repository.findById(id).orElse(null);
	}
	
	public List<? extends FruitsDataInterface> findByNameLike(String find) {
		System.out.println("Service:getByNameLike find[" + find + "]");
		return repository.findByNameLike("%" + find + "%");
	}
	
	/**
	 * 
	 * @param item
	 * @return 保存されたエンティティのID、成功しない場合0
	 */
	public int add(FruitsDataInterface item) {
		System.out.println("Service:add [" + item + "]");
		if (item instanceof Fruit) {
			Fruit savedItem = repository.saveAndFlush((Fruit)item);
			return savedItem.getId();
		}
		return 0;
	}
	
	public void delete(FruitsDataInterface item) {
		System.out.println("Service:delete[" + item + "]");
		if (item instanceof Fruit) {
			repository.delete((Fruit) item);
		}
	}
}
