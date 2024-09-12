package com.erick.tourismsystem.dto;

import com.erick.tourismsystem.enums.ReservationStatus;
import com.erick.tourismsystem.enums.ReviewStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ReservationDTO {
    private Long id;
    private LocalDate tourismDate;
    private String serviceName;
    private ReservationStatus reservationStatus;
    private ReviewStatus reviewStatus;
    private Long userId;
    private String username;
    private Long companyId;
    private Long tourismId;
}
