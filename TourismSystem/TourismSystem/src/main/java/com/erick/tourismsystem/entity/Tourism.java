package com.erick.tourismsystem.entity;

import com.erick.tourismsystem.dto.TourismDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tourisms")
@Data
public class Tourism {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private String description;

    private Double price;

    @Lob
    @Column(name = "img")
    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public TourismDTO getTourismDto() {
        TourismDTO tourismDTO = new TourismDTO();
        tourismDTO.setId(id);
        tourismDTO.setServiceName(serviceName);
        tourismDTO.setDescription(description);
        tourismDTO.setPrice(price);
        tourismDTO.setCompanyName(user.getName());
        tourismDTO.setReturnedImg(img);

        return tourismDTO;
    }
}
