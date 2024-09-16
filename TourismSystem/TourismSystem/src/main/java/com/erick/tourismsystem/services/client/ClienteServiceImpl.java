package com.erick.tourismsystem.services.client;

import com.erick.tourismsystem.dto.ReservationDTO;
import com.erick.tourismsystem.dto.ReviewDTO;
import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.dto.TourismDetailsForClientDTO;
import com.erick.tourismsystem.entity.Reservation;
import com.erick.tourismsystem.entity.Review;
import com.erick.tourismsystem.entity.Tourism;
import com.erick.tourismsystem.entity.User;
import com.erick.tourismsystem.enums.ReservationStatus;
import com.erick.tourismsystem.enums.ReviewStatus;
import com.erick.tourismsystem.repository.ReservationRepository;
import com.erick.tourismsystem.repository.ReviewRepository;
import com.erick.tourismsystem.repository.TourismRepository;
import com.erick.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private ReviewRepository reviewRepository;

    public List<TourismDTO> getAllTourisms() {
        return tourismRepository.findAll().stream().map(Tourism::getTourismDto).collect(Collectors.toList());
    }

    @Transactional
    public List<TourismDTO> searchTourismByName(String name) {
        return tourismRepository.findAllByServiceNameContainingIgnoreCase(name)
                .stream()
                .map(Tourism::getTourismDto)
                .collect(Collectors.toList());
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

            List<Review> reviewList = reviewRepository.findAllByTourismId(tourismId);
            tourismDetailsForClientDTO.setReviewDTOList(reviewList.stream().map(Review::getDto).collect(Collectors.toList()));
        }
        return tourismDetailsForClientDTO;
    }

    @Transactional
    public List<ReservationDTO> getAllServicesByUserId(Long userId) {
        return reservationRepository.findAllByUserId(userId).stream().map(Reservation::getReservationDto).collect(Collectors.toList());
    }

    public Boolean giveReview(ReviewDTO reviewDTO) {
        Optional<User> optionalUser = userRepository.findById(reviewDTO.getUserId());
        Optional<Reservation> optionalService = reservationRepository.findById(reviewDTO.getServiceId());

        if (optionalUser.isPresent() && optionalService.isPresent()) {
            Review review = new Review();

            review.setReviewDate(new Date());
            review.setReview(reviewDTO.getReview());
            review.setRating(reviewDTO.getRating());

            review.setUser(optionalUser.get());
            review.setTourism(optionalService.get().getTourism());

            reviewRepository.save(review);
            Reservation service = optionalService.get();
            service.setReviewStatus(ReviewStatus.TRUE);

            reservationRepository.save(service);

            return true;
        }

        return false;
    }
}
