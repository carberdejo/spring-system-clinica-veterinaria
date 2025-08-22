package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.geom.Area;

public interface AreasRep extends JpaRepository<Areas, Long> {
    boolean existsByNomArea(String nomArea);
            Areas findByNomArea(String nomArea);
}
