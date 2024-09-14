package com.erick.tourismsystem.repository;

import com.erick.tourismsystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
