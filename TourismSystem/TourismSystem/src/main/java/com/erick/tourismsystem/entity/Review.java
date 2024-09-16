package com.erick.tourismsystem.entity;

import com.erick.tourismsystem.dto.ReviewDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date reviewDate;

    private String review;

    private Long rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tourism_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tourism tourism;

    public ReviewDTO getDto() {
        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setId(id);
        reviewDTO.setReview(review);
        reviewDTO.setRating(rating);
        reviewDTO.setReviewDate(reviewDate);
        reviewDTO.setUserId(user.getId());
        reviewDTO.setClientName(user.getName());
        reviewDTO.setTourismId(tourism.getId());
        reviewDTO.setServiceName(tourism.getServiceName());

        return reviewDTO;
    }
}
