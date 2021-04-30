package com.example.pruebabackendspring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	private String idDocument;
	private String adress;
	private String fullname;
	private String email;
	
//	
//	@ManyToMany
//	private Set<Orders> orders = new HashSet<Orders>(0);
//	
//	
//	
	
	
	
public Account() {
		super();
	}
//	@ManyToOne
//	private Orders orders;
//	
	
	
	
//	public Orders getOrders() {
//		return orders;
//	}
//	public void setOrders(Orders orders) {
//		this.orders = orders;
//	}
	
	
	
	
	public Account(String username, String password, String idDocument, String adress, String fullname, String email,
			Set<Orders> orders) {
		super();
		this.username = username;
		this.password = password;
		this.idDocument = idDocument;
		this.adress = adress;
		this.fullname = fullname;
		this.email = email;
//		this.orders = orders;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public Set<Orders> getOrderses() {
//		return orderses;
//	}
//	public void setOrderses(Set<Orders> orderses) {
//		this.orderses = orderses;
//	}
//	
//	public Set<Orders> getOrderses() {
//		return orderses;
//	}
//	public void setOrderses(Set<Orders> orderses) {
//		this.orderses = orderses;
//	}
//		
////	
//	public Set<Orders> getOrders() {
//		return orders;
//	}
//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}
//	
	
}
