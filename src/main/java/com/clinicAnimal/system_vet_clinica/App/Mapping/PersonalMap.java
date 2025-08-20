package com.clinicAnimal.system_vet_clinica.App.Mapping;

import com.clinicAnimal.system_vet_clinica.Domain.Models.Personal;
import com.clinicAnimal.system_vet_clinica.Domain.Models.Roles;
import com.clinicAnimal.system_vet_clinica.Web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.PersonalResponseDTO;

public interface PersonalMap {
    Personal toEntity(PersonalRequestDTO dto, Roles roles);
    PersonalResponseDTO toDto(Personal entity);
}
