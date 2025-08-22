package com.clinicAnimal.system_vet_clinica.aplication.service;

import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RolesResponseDTO;

import java.util.List;

public interface PersonalService {
    PersonalResponseDTO crear(PersonalRequestDTO personalRequestDTO);
    List<Roles> listar();
    RolesResponseDTO obtenerporId(Long id);
}
