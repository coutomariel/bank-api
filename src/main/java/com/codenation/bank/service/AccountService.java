package com.codenation.bank.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codenation.bank.model.Account;
import com.codenation.bank.repository.AccountRepository;

@Service
public class AccountService {

	private AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	
	public Account saveAccount(Account account) {
		account.setSaldo(new BigDecimal(150));
		return accountRepository.save(account);
	}


	public List<Account> getAccountsByClientId(Long clientId) {
		return accountRepository.findAccountsByClientId(clientId);
	}
	
	
}
