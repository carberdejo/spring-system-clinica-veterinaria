package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolesRep extends JpaRepository<Roles, Long> {
    boolean existsByRolNombre(String rolNombre);
    Roles findByRolNombre(String rolNombre);
}
