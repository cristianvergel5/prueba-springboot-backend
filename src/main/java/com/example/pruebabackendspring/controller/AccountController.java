 package com.example.pruebabackendspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pruebabackendspring.entity.Account;
import com.example.pruebabackendspring.helper.BCrypt;
import com.example.pruebabackendspring.services.AccountService;


@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "account/index";
	}
	 
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup(ModelMap modelmap) {
		modelmap.put("account", new Account());
		return "account/signup";
	}
	
	

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("account") Account account , ModelMap modelmap) {
		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
		accountService.create(account);
		return "redirect:../account";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, 
			ModelMap modelMap, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = accountService.login(username, password);
		if(account == null) {
			modelMap.put("error", "Cuenta incorrecta");
			return "account/index";
		} else {
			session.setAttribute("username", username);
			return "redirect:../cart";
		}
		
	}
	
	//buscar id en lista de cuentas
	
//	private String isExistsAccount(int id, List<allAccount> account) {
//		for(int i=0; i< account.size(); i++) {
//				if(account.get()) {
//					return i;
//				}
//		}
//		return -1;
//	}
	

		
	
}
