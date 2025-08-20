package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRep extends JpaRepository<Roles, Long> {
    boolean existsByRolNombre(String rolNombre);
}
