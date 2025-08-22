package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalResponseDTO;

public interface PersonalMap {
    Personal toEntity(PersonalRequestDTO dto, Roles roles);
    PersonalResponseDTO toDto(Personal entity);
}
