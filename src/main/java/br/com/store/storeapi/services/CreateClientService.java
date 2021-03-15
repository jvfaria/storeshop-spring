package br.com.store.storeapi.services;

import br.com.store.storeapi.model.Client;
import br.com.store.storeapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateClientService {

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<Client> create(Client client) {
        clientRepository.save(client);

        return ResponseEntity.ok().body(client);

    }
}
