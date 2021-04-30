package com.example.pruebabackendspring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebabackendspring.dao.AccountDao;
import com.example.pruebabackendspring.entity.Account;
import com.example.pruebabackendspring.helper.BCrypt;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public void create(Account account) {
		// TODO Auto-generated method stub
		accountDao.save(account); 
		
	}

	@Override
	public Account login(String username, String password) {
		
		Account account = this.findByID(username);
		if(account!=null) {
			if(BCrypt.checkpw(password, account.getPassword())) {
				return account;
			}
		}
		
		
		return null;
	}

	@Override
	public Account findByID(String username) {
		// TODO Auto-generated method stub
		return accountDao.findById(username).orElse(null);
	}

	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}


	

}
