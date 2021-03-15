package br.com.store.storeapi.controller;

import br.com.store.storeapi.model.Client;
import br.com.store.storeapi.repositories.ClientRepository;
import br.com.store.storeapi.services.CreateClientService;
import br.com.store.storeapi.services.DeleteClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    CreateClientService createClientService;
    DeleteClientService deleteClientService;

//    get all clients
    @GetMapping("/clients")
    public List<Client> listAll(@RequestParam(value = "name", required = false) Optional<String> name) {
        if(!name.isPresent()) {
            return clientRepository.findAll();
        }
        return clientRepository.findByNameContains(name.get());
    }

//    get client by id
    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }


////    get all clients by name
//    @GetMapping("/clients")
//    public List<Client> findByName(@RequestParam(value = "name", required = false) String name) {
//        List<Client> clients = clientRepository.findByNameContains(name);
//
//        System.out.println("name:" + name);
//        return clients;
//    }

//    create a new client
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Client> newClient(@RequestBody Client client) {
        return createClientService.create(client);
    }

//    delete a client
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable(value = "id") Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    }
