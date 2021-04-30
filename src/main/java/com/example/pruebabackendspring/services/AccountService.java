package com.example.pruebabackendspring.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.pruebabackendspring.entity.Account;
import com.example.pruebabackendspring.entity.Product;



@Service("accountService")
@Transactional
public interface AccountService {
	public void create(Account account);
	
	public Iterable<Account> findAll();
	public Account login(String username, String password);
	public Account findByID(String username);
	
	
}
