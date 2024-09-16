package com.erick.tourismsystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class TourismDetailsForClientDTO {
    public TourismDTO tourismDTO;
    private List<ReviewDTO> reviewDTOList;
}
