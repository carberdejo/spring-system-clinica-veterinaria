package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalRep extends JpaRepository<Personal, Long> {
    boolean existsByDni(String dni);
    List<Personal> findAllByEstadoPersonalNot(EstadoPersonal estado);
    List<Personal> findAllByRoles_RolNombreAndEstadoPersonalNot(String rolNombre, EstadoPersonal estadoPersonal);

}
