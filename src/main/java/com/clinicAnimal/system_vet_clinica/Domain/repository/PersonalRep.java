package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRep extends JpaRepository<Personal, Long> {
}
