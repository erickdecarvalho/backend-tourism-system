package com.erick.tourismsystem.repository;

import com.erick.tourismsystem.entity.Tourism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourismRepository extends JpaRepository<Tourism, Long> {
}
