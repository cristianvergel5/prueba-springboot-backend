package com.example.pruebabackendspring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pruebabackendspring.dao.OrdersDetailDao;
import com.example.pruebabackendspring.entity.OrdersDetail;


@Service("ordersDetailService")
@Transactional
public class OrdersDetailServiceImpl implements OrdersDetailService{
	
	@Autowired
	private OrdersDetailDao OrdersDetailDao;
	
	@Override
	public OrdersDetail create(OrdersDetail ordersDetail) {
		return OrdersDetailDao.save(ordersDetail ) ;
	}

}
