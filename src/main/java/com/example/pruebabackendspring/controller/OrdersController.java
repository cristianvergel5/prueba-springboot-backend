package com.example.pruebabackendspring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import com.example.pruebabackendspring.entity.ItemOrders;
import com.example.pruebabackendspring.services.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("orders")
public class OrdersController {
	
	
	
	@Autowired
	private OrdersService ordersService;

//	//listar orderes del usuario
//	@RequestMapping(method = RequestMethod.GET)
//	private String index(ModelMap modelMap, HttpSession session) {
//		modelMap.put(key, value);
//		
//	}
	
	
	//listar orderes
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("orders", ordersService.findAll());
		return "order/mostrar";
		
	}
	
	
	
	//mostrar orders
	@RequestMapping(value = "ordersList/{id}" , method = RequestMethod.GET)
	public String listOrders(@PathVariable("id") int id, HttpSession session) {
		if(session.getAttribute("orders") == null){
			List<ItemOrders> orders = new ArrayList<ItemOrders>();
			orders.add(new ItemOrders(ordersService.findById(id)));
			session.setAttribute("orders", orders);
		} else {
			List<ItemOrders> orders = (List<ItemOrders>) session.getAttribute("orders");
			int index  = IsExists(id, orders);
				if (index == -1) {
					orders.add(new ItemOrders(ordersService.findById(id)));
				
				}
			session.setAttribute("orders", orders);
		}
		return "redirect:../../cart";
	}
	
	
	
	//buscar orders
	private int IsExists(int id, List<ItemOrders> orders) {
		for(int i = 0; i< orders.size(); i++) {
			if(orders.get(i).getOrders().getId() == id) {
				return i;
			}
			
		}
		return -1;
	}
	
	
	
}
