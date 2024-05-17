package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.FruitsDataInterface;
import com.example.demo.data.FruitsDataService;
import com.example.demo.model.Fruit;


@RestController
public class SampleController {
	@Autowired
	FruitsDataService service;

	// 動的データが関係しないので廃止
//	@GetMapping("/")
//	public ModelAndView index(ModelAndView mv) {
//		System.out.println("index");
//		mv.setViewName("index");
//		mv.addObject("title", "サンプル");
//		mv.addObject("msg", "これはサンプルのメッセージです。");
//		return mv;
//	}
	
	@GetMapping("/fruits")
	@CrossOrigin
	public List<? extends FruitsDataInterface> fruits() {
		System.out.println("fruits/index");
		return service.getAll();
	}

	@GetMapping("/fruits/{id}")
	@CrossOrigin
	public FruitsDataInterface fruitById(@PathVariable int id) {
		System.out.println("fruits/findById");
		return service.getById(id);
	}

	// 動的データが関係しないので廃止
//	@GetMapping("/fruits/add")
//	public ModelAndView add(ModelAndView mv) {
//		System.out.println("fruits/add");
//		mv.setViewName("fruits/add");
//		mv.addObject("title", "新規登録");
//		mv.addObject("msg", "新たに情報を登録します");
//		return mv;
//	}
	
	// 動的データが関係しないので廃止
//	@GetMapping("/fruits/update")
//	public ModelAndView update(ModelAndView mv, @RequestParam("id") Integer id) {
//		System.out.println("fruits/update");
//		mv.setViewName("fruits/update");
//		mv.addObject("title", "更新");
//		mv.addObject("msg", "ID=" + id + "の登録情報を更新します");
//		Optional<Fruit> form = this.repository.findById(id);
//		mv.addObject("form", form.orElse(new Fruit()));
//		return mv;
//	}

	// 動的データが関係しないので廃止
//	@GetMapping("/fruits/delete")
//	public ModelAndView delete(ModelAndView mv, @RequestParam("id") Integer id) {
//		System.out.println("fruits/delete");
//		mv.setViewName("fruits/delete");
//		mv.addObject("title", "削除");
//		mv.addObject("msg", "ID=" + id + "の登録情報を削除します");
//		Optional<Fruit> form = this.repository.findById(id);
//		mv.addObject("form", form.orElse(new Fruit()));
//		return mv;
//	}

	@PostMapping("/fruits/add")
	@CrossOrigin
	public int add(@RequestBody Fruit fruit) {
		System.out.println("fruits/add(post)");
		return service.add(fruit);
	}

	@PostMapping("/fruits/update")
	@CrossOrigin
	public int update(@RequestBody Fruit fruit) {
		System.out.println("fruits/update(post)");
		return service.add(fruit);
	}

	@PostMapping("/fruits/delete")
	@CrossOrigin
	public void delete(@RequestBody Fruit fruit) {
		System.out.println("fruits/delete(post)");
		service.delete(fruit);
	}
	
	// 動的データが関係しないので廃止
//	@GetMapping("/fruits/find")
//	public ModelAndView find(ModelAndView mv) {
//	  mv.setViewName("/fruits/find");
//	  mv.addObject("title", "検索");
//	  mv.addObject("msg", "フルーツ在庫を検索します。");
//	  mv.addObject("find","");
//	  return mv;
//	}
	 
	@PostMapping("/fruits/find")
	@CrossOrigin
	public List<? extends FruitsDataInterface> find(@RequestParam("find") String find) {
		System.out.println("fruits/find(post)");
		return service.findByNameLike(find);
	}
}
