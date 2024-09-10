package com.erick.tourismsystem.services.company;

import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.entity.Tourism;
import com.erick.tourismsystem.entity.User;
import com.erick.tourismsystem.repository.TourismRepository;
import com.erick.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

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

}
