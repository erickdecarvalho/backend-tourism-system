package com.erick.tourismsystem.entity;

import com.erick.tourismsystem.dto.ReservationDTO;
import com.erick.tourismsystem.enums.ReservationStatus;
import com.erick.tourismsystem.enums.ReviewStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Date tourismDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tourism_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tourism tourism;

    public ReservationDTO getReservationDto() {
        ReservationDTO dto = new ReservationDTO();

        dto.setId(id);
        dto.setServiceName(tourism.getServiceName());
        dto.setTourismDate(tourismDate);
        dto.setReservationStatus(reservationStatus);
        dto.setReviewStatus(reviewStatus);

        dto.setTourismId(tourism.getId());
        dto.setCompanyId(company.getId());
        dto.setUsername(user.getName());

        return dto;
    }
}
