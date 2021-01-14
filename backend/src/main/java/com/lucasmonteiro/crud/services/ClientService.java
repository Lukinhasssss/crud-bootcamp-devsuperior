package com.lucasmonteiro.crud.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasmonteiro.crud.dto.ClientDTO;
import com.lucasmonteiro.crud.entities.Client;
import com.lucasmonteiro.crud.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> clients = repository.findAll();
		return clients.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
	}

}
