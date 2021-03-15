package br.com.store.storeapi.services;

import br.com.store.storeapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientService {

    @Autowired
    ClientRepository clientRepository;

    public void remove(Long id) {
        clientRepository.deleteById(id);
    }
}
