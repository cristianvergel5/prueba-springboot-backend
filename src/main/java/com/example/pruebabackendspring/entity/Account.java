package com.example.pruebabackendspring.entity;

import java.io.Serializable;
import java.util.HashSet;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String fullname;
	private String email;
//	private Set<Orders> orderses = new HashSet<Orders>(0);
	
	
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
		
	
	
	
}
