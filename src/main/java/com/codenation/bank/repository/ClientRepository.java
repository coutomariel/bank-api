package com.codenation.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenation.bank.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	
}
