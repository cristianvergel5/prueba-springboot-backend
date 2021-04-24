//package com.example.pruebabackendspring.entity;
//
//import java.sql.Date;
//import java.util.HashSet;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//
////@Entity
////@Table(name="orders" ,catalog="example.pruebabackendspring")
//public class Orders implements java.io.Serializable{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	private Integer id;
//	private Account account;
//	private String name;
//	private Date datecreation;
//	private boolean status;
//private List<Ordersdetail> ordersdetail = (List<Ordersdetail>) new HashSet<Ordersdetail>(0);
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Account getAccount() {
//		return account;
//	}
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Date getDatecreation() {
//		return datecreation;
//	}
//	public void setDatecreation(Date datecreation) {
//		this.datecreation = datecreation;
//	}
//	public boolean isStatus() {
//		return status;
//	}
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
////	public List<Ordersdetail> getOrdersdetail() {
////		return ordersdetail;
////	}
////	public void setOrdersdetail(List<Ordersdetail> ordersdetail) {
////		this.ordersdetail = ordersdetail;
////	}
////	public static long getSerialversionuid() {
////		return serialVersionUID;
////	}
////	
////	
//	
//}
