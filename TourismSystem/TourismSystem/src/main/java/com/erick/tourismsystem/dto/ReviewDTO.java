package com.erick.tourismsystem.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ReviewDTO {
    private Long id;

    private Date reviewDate;

    private String review;

    private Long rating;

    private Long userId;

    private Long tourismId;

    private String clientName;

    private String serviceName;

    private Long serviceId;
}
