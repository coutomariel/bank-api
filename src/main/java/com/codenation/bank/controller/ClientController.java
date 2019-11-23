package com.codenation.bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codenation.bank.model.Client;
import com.codenation.bank.service.ClientService;

@Controller
@RequestMapping("v1/clients")
public class ClientController {

	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity salvar(@RequestBody Client client) {
		Client clientSave = clientService.saveClient(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientSave);
	}

	@PutMapping
	public ResponseEntity atualizar(@RequestBody Client client) {
		clientService.saveClient(client);
		return ResponseEntity.status(HttpStatus.OK).body(client);
	}

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Long id) {
		Optional<Client> client = clientService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deletar(@PathVariable Long id) {
		clientService.deleteById(id);
	}

}
