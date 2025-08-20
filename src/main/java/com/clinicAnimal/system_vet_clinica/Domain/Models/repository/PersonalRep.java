package com.clinicAnimal.system_vet_clinica.Domain.Models.repository;

import com.clinicAnimal.system_vet_clinica.Domain.Models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRep extends JpaRepository<Personal, Long> {
}
