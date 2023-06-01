package com.product.springjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@PostMapping("saveProduct")
	public void saveproduct(@RequestBody Product pro) {
		System.out.println(pro);
		repo.save(pro);
	}

	@GetMapping("getproducts")
	public List<Product> getallproducts() {
		return repo.findAll();
	}

	@GetMapping("getbyid/{id}")
	public Optional<Product> getproduct(@PathVariable Integer id) {
		return repo.findById(id);
	}

	@GetMapping("getbyname/{name}")
	public List<Product> getproductByname(@PathVariable String name) {
		return repo.findBypname(name);
	}
	
	@GetMapping("getgreaterthansal/{price}")
	public List<Product> getproductsal(@PathVariable Double price) {
		return repo.findByPriceGreaterThan(price);
	}
	@GetMapping("getLessthansal/{price}")
	public List<Product> getproductLESSsal(@PathVariable Double price) {
		return repo.findByPriceLessThan(price);
	}

	@GetMapping("getproduclikename/{name}")
	public List<Product> getproduclikename(@PathVariable String name) {
		return repo.findBypnameLike(name+"%");
	}
	
	@GetMapping("getproducnotlikename/{name}")
	public List<Product> getproducnotlikename(@PathVariable String name) {
		return repo.findBypnameNotLike(name+"%");
	}
	
	@GetMapping("getproducbetweendate/{startdate}/{enddate}")
	public List<Product> getproducbetweendate(@PathVariable String startdate,@PathVariable String enddate) throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-mm-dd");
	Date start =  d.parse(startdate);
	Date end   =  d.parse(enddate);
		return repo.findByDomBetween(start ,end);
	}
	@GetMapping("getproducbetweenprice/{start}/{end}")
	public List<Product> getproducbetweenprice(@PathVariable Double start,@PathVariable Double end) {
		return repo.findByPriceBetween(start, end);
	}
}
