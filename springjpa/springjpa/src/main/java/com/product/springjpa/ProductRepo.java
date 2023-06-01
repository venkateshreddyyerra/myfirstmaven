package com.product.springjpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

	
	public abstract List<Product> findBypname(String name);
	
	public abstract List<Product> findByPriceGreaterThan(Double price);
	
	public abstract List<Product> findByPriceLessThan(Double price);
	
	public abstract List<Product> findBypnameLike(String name);
	
	public abstract List<Product> findBypnameNotLike(String name);

	public abstract List<Product> findByDomBetween(Date start,Date end);

	public abstract List<Product> findByPriceBetween(Double start,Double end);

}
