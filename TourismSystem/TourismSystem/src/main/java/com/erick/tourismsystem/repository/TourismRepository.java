package com.erick.tourismsystem.repository;

import com.erick.tourismsystem.dto.TourismDTO;
import com.erick.tourismsystem.entity.Tourism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourismRepository extends JpaRepository<Tourism, Long> {

    List<Tourism> findAllByUserId(Long userId);
    List<Tourism> findAllByServiceNameContaining(String name);
    List<Tourism> findAllByServiceNameContainingIgnoreCase(String name);

}
