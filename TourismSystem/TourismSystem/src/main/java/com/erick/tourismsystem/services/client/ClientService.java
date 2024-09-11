package com.erick.tourismsystem.services.client;

import com.erick.tourismsystem.dto.TourismDTO;

import java.util.List;

public interface ClientService {
    List<TourismDTO> getAllTourisms();
}
