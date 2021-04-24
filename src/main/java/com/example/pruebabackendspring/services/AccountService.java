package com.example.pruebabackendspring.services;

import com.example.pruebabackendspring.entity.Account;

public interface AccountService {
	public void create(Account account);
	
	public Account login(String username, String password);
	public Account findByID(String username);
	
	
}
