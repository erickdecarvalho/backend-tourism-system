package com.erick.tourismsystem.services.client;

import com.erick.tourismsystem.dto.ReservationDTO;
import com.erick.tourismsystem.dto.ReviewDTO;
import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.dto.TourismDetailsForClientDTO;

import java.util.List;

public interface ClientService {
    List<TourismDTO> getAllTourisms();
    List<TourismDTO> searchTourismByName(String name);
    boolean tourismService(ReservationDTO reservationDTO);
    TourismDetailsForClientDTO getTourismDetailsByTourismid(Long tourismId);
    List<ReservationDTO> getAllServicesByUserId(Long userId);
    Boolean giveReview(ReviewDTO reviewDTO);
}

