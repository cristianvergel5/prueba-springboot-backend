package com.example.pruebabackendspring.services;



import com.example.pruebabackendspring.entity.Product;

public interface ProductService {
	
	public Iterable<Product> findAll();
	
	public Product findById(int id);
	
	
}
