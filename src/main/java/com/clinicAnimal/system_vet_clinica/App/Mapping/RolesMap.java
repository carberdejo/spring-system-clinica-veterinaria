package com.clinicAnimal.system_vet_clinica.App.Mapping;

import com.clinicAnimal.system_vet_clinica.Domain.Models.Roles;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesResponseDTO;

public interface RolesMap {
    Roles toEntity(RolesRequestDTO dto);
    RolesResponseDTO toDto(Roles entity);
}
