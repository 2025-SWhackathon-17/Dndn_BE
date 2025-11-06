package com.example.dndn_be.domain.incident.domain.repository;

import com.example.dndn_be.domain.incident.domain.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
