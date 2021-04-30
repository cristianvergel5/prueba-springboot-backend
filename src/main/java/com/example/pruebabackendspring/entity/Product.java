package com.example.pruebabackendspring.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Product implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;
    private String code;
    private String description;
    private String photo;
    private Float price;
    private Float quantity;
    private Float shippingCost;
	
    

    
    
    
    public Product() {
		super();
	}
	public Product(Integer id, String name, String code, String description, String photo, Float price, Float quantity,
			Float shippingCost, OrdersDetail ordersdetail) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.photo = photo;
		this.price = price;
		this.quantity = quantity;
		this.shippingCost = shippingCost;

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public Float getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(Float shippingCost) {
		this.shippingCost = shippingCost;
	}
	

}