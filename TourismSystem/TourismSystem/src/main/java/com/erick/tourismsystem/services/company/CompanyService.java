package com.erick.tourismsystem.services.company;

import com.erick.tourismsystem.dto.TourismDTO;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    boolean postTourism(Long userId, TourismDTO tourismDTO) throws IOException;
    List<TourismDTO> getAllTourisms(Long userId);
    TourismDTO getTourismById(Long tourismId);
    boolean updateTourism(Long tourismId, TourismDTO tourismDTO) throws IOException;
}
