package com.ratemesh.controller;

import com.ratemesh.model.Client;
import com.ratemesh.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController
{
    private ClientService service;

    @Autowired
    public ClientController(ClientService service)
    {
        this.service = service;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients()
    {
        List<Client> allClients = service.getAllClients();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> addNewClient(@RequestBody Client client)
    {
        Client newClient = service.addNewClient(client);

        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
}
