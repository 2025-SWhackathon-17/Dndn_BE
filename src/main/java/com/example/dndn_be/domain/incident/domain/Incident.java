package com.example.dndn_be.domain.incident.domain;

import com.example.dndn_be.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String incidentTitle;

    private String description;

    private Double latitude; // 위도

    private Double longitude; // 경도

    private String incidentImage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user-id")
    private User user;

    public void update(String incidentTitle, String description,
                       Double latitude, Double longitude, String incidentImage) {
        this.incidentTitle = incidentTitle;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.incidentImage = incidentImage;
    }
}
