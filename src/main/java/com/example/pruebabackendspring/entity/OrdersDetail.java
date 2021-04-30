package com.example.pruebabackendspring.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdersDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	
	
	private Integer productId;
	
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Orders orders;
	
	private Float price;
	private Float priceTotal;
	private int quantity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Float priceTotal) {
		this.priceTotal = priceTotal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public OrdersDetail(Integer id, Integer productId, Product product, Orders orders, Float price, Float priceTotal,
			int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.product = product;
		this.orders = orders;
		this.price = price;
		this.priceTotal = priceTotal;
		this.quantity = quantity;
	}
	public OrdersDetail() {
		super();
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
}
