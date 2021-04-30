package com.example.pruebabackendspring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.pruebabackendspring.entity.Item;
import com.example.pruebabackendspring.entity.Orders;
import com.example.pruebabackendspring.entity.OrdersDetail;
import com.example.pruebabackendspring.entity.Product;
import com.example.pruebabackendspring.services.AccountService;
import com.example.pruebabackendspring.services.OrdersDetailService;
import com.example.pruebabackendspring.services.OrdersService;
import com.example.pruebabackendspring.services.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OrdersService orderService;
	
	@Autowired
	private OrdersDetailService ordersDetailService;

	// calcula costo de compra
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap ,HttpSession session) {
		modelMap.put("totalShippingCost", totalShippingCost(session));
		modelMap.put("ValueTotal", ValueTotal(session));
		modelMap.put("ValueTotalEnvio", ValueTotalEnvio(session));
		
		return "cart/index";
	}
	
	// agregar producto a carrito
	@RequestMapping(value = "buy/{id}" , method = RequestMethod.GET)
	public String buy(@PathVariable("id") int id,  HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productService.findById(id), 1));
			session.setAttribute("cart", cart);
			
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = IsExists(id, cart);
				if(index==-1) {
					cart.add(new Item(productService.findById(id), 1));
				} else {
					int quantity = cart.get(index).getQuantity() + 1; 
					cart.get(index).setQuantity(quantity);
				}
				session.setAttribute("cart", cart);
			}
		return "redirect:../../cart";
	}
	
	
	//eliminar
	@RequestMapping(value = "remove/{id}" , method = RequestMethod.GET)
	public String remove(@PathVariable("id") int id,   HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = IsExists(id, cart);
		session.setAttribute("cart", cart);
		cart.remove(index);
		return "redirect:../../cart";
	}
	
	//actualizar carrito
	@RequestMapping(value = "update" , method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		  String[] quantities =  request.getParameterValues("quantity"); 
		  List<Item> cart = (List<Item>) session.getAttribute("cart");
		  
		  for(int i = 0;i< cart.size(); i++){
			  cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		  }
		  session.setAttribute("cart", cart);
		  
		return "redirect:../cart";
	}
	
	//verificar
	@RequestMapping(value= "checkout",method = RequestMethod.GET)
	public String checkout(HttpSession session) {
		if(session.getAttribute("username") == null) {
			return "redirect:../account";
		} else {
			//agregar orden
			Orders orders = new Orders();
			orders.setAccount(accountService.findByID((String) session.getAttribute("username").toString()));
			orders.setCreateAt(new Date());
			orders.setName("nueva orden");
			orders.setStatus(false);
			int OrderId = orderService.create(orders).getId();
			

			//Agragar detalles de orden
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			
			double total = totalShippingCost(session);
			
			Product product = new Product();
			
			for(Item item : cart) {
				
				OrdersDetail ordersdetail = new OrdersDetail();		
				ordersdetail.setOrders(orderService.findById(orders.getId()));
//				ordersdetail.setProduct(productService.findById(product.getId()));
				ordersdetail.setProductId(item.getProduct().getId());
				ordersdetail.setPrice(item.getProduct().getPrice());
				ordersdetail.setPriceTotal((float) total);
				ordersdetail.setQuantity(item.getQuantity());
				ordersDetailService.create(ordersdetail);
			}
			
			//Eliminar carrito
			session.removeAttribute("cart");
			
			return "order/thanks";
		}
	}

	
	//buscar id en list de Items
	private int IsExists(int id, List<Item> cart) {
		for(int i = 0; i < cart.size(); i++	) {
			if(cart.get(i).getProduct().getId() ==id) {
				return i;
			}
		}
		return -1;
	}

	
	// Metodo para descontar el envio si el pedido es mayor a $100000 (item 2 de la prueba)
	private double totalShippingCost(HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		
		double priceItems= 0;
		double shippingCost = 0;
		
		double total = 0;
		double totalIva = 0;
				
		//valor para envio gratis		
		double priceMax = 100000.0;
		
		
		//valor apartir del cual se cobra iva
		double priveMaxIva = 70000;
		
		
		double IVA = 0.19;
		
		if(cart!=null) {
			for(Item item : cart) {
				priceItems += item.getQuantity() * item.getProduct().getPrice().doubleValue();		
			}
		}
			
		if(cart!=null) {
			for(Item item:cart) {
				shippingCost += item.getQuantity() * item.getProduct().getShippingCost().doubleValue();
			}
		
		}
		
		
		
		if(priceItems > priveMaxIva && priceItems<priceMax) {
			total = priceItems * IVA;
			totalIva = priceItems + shippingCost +total;
			return totalIva;
		} 
		
		if (priceItems<priveMaxIva){
			totalIva = priceItems + shippingCost;
			return totalIva;
		}
		
		if(priceItems>priceMax) {
			total = priceItems * IVA;
			totalIva = priceItems + total;
		}
			
		
		return totalIva;
	}
	
	
	
	private double ValueTotal(HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		
		double s = 0;
		double IVA = 0;
		
		if(cart!=null) {
			for(Item item : cart) {
				s+= item.getQuantity() * item.getProduct().getPrice().doubleValue();	
			}
		}
		
		return s;
		
	}
	
	private double ValueTotalEnvio(HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		
		double s = 0;
		
		if(cart!=null) {
			for(Item item : cart) {
				s+=item.getQuantity() * item.getProduct().getShippingCost().doubleValue();
			}
		}
		
		return s;
		
	}
	

}
