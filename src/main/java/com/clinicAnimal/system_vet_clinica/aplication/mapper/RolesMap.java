package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesResponseDTO;

public interface RolesMap {
    Roles toEntity(RolesRequestDTO dto);
    RolesResponseDTO toDto(Roles entity);
}
