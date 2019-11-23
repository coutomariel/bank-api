package com.codenation.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codenation.bank.model.Client;
import com.codenation.bank.repository.ClientRepository;

@Service
public class ClientService {
	
	private ClientRepository clientrepository;

	@Autowired
	public ClientService(ClientRepository clientrepository) {
		this.clientrepository = clientrepository;
	}

	public Client saveClient(Client client) {
		return clientrepository.save(client); 

	}

	public Optional<Client> findById(Long id) {
		return clientrepository.findById(id);
	}

	public void deleteById(Long id) {
		clientrepository.deleteById(id);
		
	}

}