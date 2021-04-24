package com.example.pruebabackendspring.services;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebabackendspring.dao.ProductDao;
import com.example.pruebabackendspring.entity.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Iterable<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findById(int id) {
		return productDao.findById(id).orElse(null);
	}

}
