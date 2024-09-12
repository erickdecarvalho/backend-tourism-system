package com.erick.tourismsystem.services.client;

import com.erick.tourismsystem.dto.ReservationDTO;
import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.dto.TourismDetailsForClientDTO;
import com.erick.tourismsystem.entity.Reservation;
import com.erick.tourismsystem.entity.Tourism;
import com.erick.tourismsystem.entity.User;
import com.erick.tourismsystem.enums.ReservationStatus;
import com.erick.tourismsystem.enums.ReviewStatus;
import com.erick.tourismsystem.repository.ReservationRepository;
import com.erick.tourismsystem.repository.TourismRepository;
import com.erick.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClientService{

    @Autowired
    private TourismRepository tourismRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<TourismDTO> getAllTourisms() {
        return tourismRepository.findAll().stream().map(Tourism::getTourismDto).collect(Collectors.toList());
    }

    @Transactional
    public List<TourismDTO> searchTourismByName(String name) {
        return tourismRepository.findAllByServiceNameContaining(name).stream().map(Tourism::getTourismDto).collect(Collectors.toList());
    }

    public boolean tourismService(ReservationDTO reservationDTO) {
        Optional<Tourism> optionalTourism = tourismRepository.findById(reservationDTO.getTourismId());
        Optional<User> optionaluser = userRepository.findById(reservationDTO.getUserId());

        if(optionaluser.isPresent() && optionaluser.isPresent()) {
            Reservation reservation = new Reservation();

            reservation.setTourismDate(reservationDTO.getTourismDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);
            reservation.setUser(optionaluser.get());

            reservation.setTourism(optionalTourism.get());
            reservation.setCompany(optionalTourism.get().getUser());
            reservation.setReviewStatus(ReviewStatus.FALSE);

            reservationRepository.save(reservation);
            return true;
        }

        return false;
    }

    public TourismDetailsForClientDTO getTourismDetailsByTourismid(Long tourismId) {
        Optional<Tourism> optionalTourism = tourismRepository.findById(tourismId);
        TourismDetailsForClientDTO tourismDetailsForClientDTO = new TourismDetailsForClientDTO();
        if(optionalTourism.isPresent()) {
            tourismDetailsForClientDTO.setTourismDTO(optionalTourism.get().getTourismDto());
        }
        return tourismDetailsForClientDTO;
    }
}
