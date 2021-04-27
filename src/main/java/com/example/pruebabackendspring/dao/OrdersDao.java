package com.example.pruebabackendspring.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.pruebabackendspring.entity.Orders;

public interface OrdersDao extends CrudRepository<Orders, Integer>{

}
