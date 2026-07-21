package com.ratemesh.service;

import com.ratemesh.model.Client;
import com.ratemesh.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService
{
    private ClientRepository repo;

    @Autowired
    public ClientService(ClientRepository repo)
    {
        this.repo = repo;
    }

    public List<Client> getAllClients()
    {
        return repo.findAll();
    }

    public Client addNewClient(Client client)
    {
        return repo.save(client);
    }
}
