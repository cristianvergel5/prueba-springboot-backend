package com.example.pruebabackendspring.dao;

import com.example.pruebabackendspring.entity.*;
import org.springframework.data.repository.CrudRepository;



public interface AccountDao extends 
	CrudRepository<Account, String>{
		
}
