package com.erick.tourismsystem.controller;

import com.erick.tourismsystem.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/turismos")
    public ResponseEntity<?> getAllTourisms() {
        return ResponseEntity.ok(clientService.getAllTourisms());
    }

    @GetMapping("/turismos/procurar/{name}")
    public ResponseEntity<?> searchTourismByName(@PathVariable String name) {
        return ResponseEntity.ok(clientService.searchTourismByName(name));
    }
}
