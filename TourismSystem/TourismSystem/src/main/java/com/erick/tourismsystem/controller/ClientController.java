package com.erick.tourismsystem.controller;

import com.erick.tourismsystem.dto.ReservationDTO;
import com.erick.tourismsystem.dto.ReviewDTO;
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
        System.out.println(reservationDTO);
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

    @GetMapping("/meus-turismos/{userId}")
    public ResponseEntity<?> getAllServicesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(clientService.getAllServicesByUserId(userId));
    }

    @PostMapping("/resenha")
    public ResponseEntity<?> giveReview(@RequestBody ReviewDTO reviewDTO) {
        Boolean success = clientService.giveReview(reviewDTO);
        if(success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
