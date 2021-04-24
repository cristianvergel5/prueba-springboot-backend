package com.example.pruebabackendspring.dao;

import com.example.pruebabackendspring.entity.*;
import org.springframework.data.repository.CrudRepository;

import com.example.pruebabackendspring.entity.Product;

public interface ProductDao extends 
	CrudRepository<Product, Integer>{

}
