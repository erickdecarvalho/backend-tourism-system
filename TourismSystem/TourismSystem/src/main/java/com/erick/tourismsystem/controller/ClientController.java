package com.erick.tourismsystem.controller;

import com.erick.tourismsystem.dto.ReservationDTO;
import com.erick.tourismsystem.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/servicos-de-turismo")
    public ResponseEntity<?> tourismService(@RequestBody ReservationDTO reservationDTO) {
        boolean success = clientService.tourismService(reservationDTO);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/turismo/{tourismId}")
    public ResponseEntity<?> getTourismDetailsByTourismId(@PathVariable Long tourismId) {
        return ResponseEntity.ok(clientService.getTourismDetailsByTourismid(tourismId));
    }
}
