package com.example.pruebabackendspring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebabackendspring.dao.OrdersDao;
import com.example.pruebabackendspring.entity.Orders;



@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService{
	
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public Orders create(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.save(orders);
	}

}
