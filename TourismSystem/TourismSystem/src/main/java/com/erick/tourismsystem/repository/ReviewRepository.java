package com.erick.tourismsystem.repository;

import com.erick.tourismsystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByTourismId(Long tourismId);
}
