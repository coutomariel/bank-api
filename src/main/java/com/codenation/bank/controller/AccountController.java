package com.codenation.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codenation.bank.model.Account;
import com.codenation.bank.service.AccountService;

@Controller
@RequestMapping("/v1/accounts")
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping
	public ResponseEntity saveAccount(@RequestBody Account account) {
		List<Account> accounts = accountService.getAccountsByClientId(account.getClient().getId());
		if(accounts.size()>0) {
			throw new IllegalArgumentException("Cliente já possui uma conta");
		}
		Account accountSaved = accountService.saveAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountSaved);
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<List<Account>> findAllAccountsByClientId(@PathVariable Long clientId) {
		List<Account> accounts = accountService.getAccountsByClientId(clientId);
		return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}

}
