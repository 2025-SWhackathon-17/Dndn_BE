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

    private Double latitude;

    private Double longitude;

    private String incidentImage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user-id")
    private User user;
}
