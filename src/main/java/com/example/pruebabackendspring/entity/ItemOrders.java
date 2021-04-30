package com.example.pruebabackendspring.entity;

public class ItemOrders implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Orders orders;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ItemOrders(Orders orders) {
		super();
		this.orders = orders;
	}

	public ItemOrders() {
		super();
	}
	
	

	
	
	
	
}
