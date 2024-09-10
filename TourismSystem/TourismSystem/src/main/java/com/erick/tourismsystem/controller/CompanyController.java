package com.erick.tourismsystem.controller;

import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
}
