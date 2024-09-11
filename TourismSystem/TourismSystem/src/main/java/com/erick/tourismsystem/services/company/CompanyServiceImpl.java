package com.erick.tourismsystem.services.company;

import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.entity.Tourism;
import com.erick.tourismsystem.entity.User;
import com.erick.tourismsystem.repository.TourismRepository;
import com.erick.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TourismRepository tourismRepository;

    @Override
    public boolean postTourism(Long userId, TourismDTO tourismDTO) throws IOException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            Tourism tourism = new Tourism();
            tourism.setServiceName(tourismDTO.getServiceName());
            tourism.setDescription(tourismDTO.getDescription());
            tourism.setImg(tourismDTO.getImg().getBytes());
            tourism.setPrice(tourismDTO.getPrice());
            tourism.setUser(optionalUser.get());

            tourismRepository.save(tourism);
            return true;

        }
        return false;
    }

    @Transactional
    public List<TourismDTO> getAllTourisms(Long userId) {
        List<Tourism> tourisms = tourismRepository.findAllByUserId(userId);
        return tourisms.stream().map(Tourism::getTourismDto).collect(Collectors.toList());
    }

    public TourismDTO getTourismById(Long tourismId) {
        Optional<Tourism> optionalTourism = tourismRepository.findById(tourismId);
        if(optionalTourism.isPresent()) {
            return optionalTourism.get().getTourismDto();
        }

        return null;
    }

    public boolean updateTourism(Long tourismId, TourismDTO tourismDTO) throws IOException {
        Optional<Tourism> optionalTourism = tourismRepository.findById(tourismId);
        if(optionalTourism.isPresent()) {
            Tourism tourism = optionalTourism.get();

            tourism.setServiceName(tourismDTO.getServiceName());
            tourism.setDescription(tourismDTO.getDescription());
            tourism.setPrice(tourismDTO.getPrice());

            if(tourismDTO.getImg() != null) {
                tourism.setImg(tourismDTO.getImg().getBytes());
            }

            tourismRepository.save(tourism);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTourism(Long tourismId) {
        Optional<Tourism> optionalTourism = tourismRepository.findById(tourismId);
        if(optionalTourism.isPresent()) {
            tourismRepository.delete(optionalTourism.get());
            return true;
        }

        return false;
    }
}
