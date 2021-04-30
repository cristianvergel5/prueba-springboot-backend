package com.example.pruebabackendspring.services;

import com.example.pruebabackendspring.entity.Orders;

public interface OrdersService {
	public Orders create(Orders orders);
	
	public Iterable<Orders> findAll();
	
	public Orders findById(int id);
}
