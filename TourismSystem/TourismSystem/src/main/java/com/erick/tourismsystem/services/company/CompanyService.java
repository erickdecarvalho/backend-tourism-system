package com.erick.tourismsystem.services.company;

import com.erick.tourismsystem.dto.TourismDTO;

import java.io.IOException;

public interface CompanyService {
    boolean postTourism(Long userId, TourismDTO tourismDTO) throws IOException;
}
