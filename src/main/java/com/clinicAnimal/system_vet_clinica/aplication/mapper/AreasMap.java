package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasResponseDTO;

public interface AreasMap {
    Areas toEntity(AreasRequestDTO dto);
    AreasResponseDTO toDto(Areas entity);
}
