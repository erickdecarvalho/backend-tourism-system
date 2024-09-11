package com.erick.tourismsystem.services.client;

import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.entity.Tourism;
import com.erick.tourismsystem.repository.TourismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClientService{

    @Autowired
    private TourismRepository tourismRepository;

    public List<TourismDTO> getAllTourisms() {
        return tourismRepository.findAll().stream().map(Tourism::getTourismDto).collect(Collectors.toList());
    }

    public List<TourismDTO> searchTourismByName(String name) {
        return tourismRepository.findAllByServiceNameContaining(name).stream().map(Tourism::getTourismDto).collect(Collectors.toList());
    }
}
