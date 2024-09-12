package com.erick.tourismsystem.controller;

import com.erick.tourismsystem.dto.ReservationDTO;
import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.entity.Tourism;
import com.erick.tourismsystem.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/companhias")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/turismo/{userId}")
    public ResponseEntity<?> postTourism(@PathVariable Long userId, @ModelAttribute TourismDTO tourismDTO) throws IOException {
        boolean success = companyService.postTourism(userId, tourismDTO);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/turismos/{userId}")
    public ResponseEntity<?> getAllTourismByUserId(@PathVariable Long userId) {
        List<TourismDTO> turismos = companyService.getAllTourisms(userId);
        return ResponseEntity.ok(turismos);
    }

    @GetMapping("/turismo/{tourismId}")
    public ResponseEntity<?> getTourimById(@PathVariable Long tourismId) {
        TourismDTO tourismDTO = companyService.getTourismById(tourismId);
        if (tourismDTO != null) {
            return ResponseEntity.ok(tourismDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/turismo/{tourismId}")
    public ResponseEntity<?> updateTourism(@PathVariable Long tourismId, @ModelAttribute TourismDTO tourismDTO) throws IOException {
        boolean success = companyService.updateTourism(tourismId, tourismDTO);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/turismo/{tourismId}")
    public ResponseEntity<?> deleteTourism(@PathVariable Long tourismId) {
        boolean success = companyService.deleteTourism(tourismId);

        if(success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/turismos/dash/{companyId}")
    public ResponseEntity<List<ReservationDTO>> getAllTourismServices(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.getAllTourismServices(companyId));
    }

    @GetMapping("/turismo/{serviceId}/{status}")
    public ResponseEntity<?> changeServiceStatus(@PathVariable Long serviceId, @PathVariable String status) {
        boolean success = companyService.changeServiceStatus(serviceId, status);
        if(success) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
