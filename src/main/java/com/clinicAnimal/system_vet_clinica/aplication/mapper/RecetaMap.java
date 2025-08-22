package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Receta;
import com.clinicAnimal.system_vet_clinica.domain.model.Cita;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaUpdateDTO;

public interface RecetaMap {
    Receta toEntity(RecetaRequestDTO dto, Cita cita);
    RecetaResponseDTO toDto(Receta entity);
    void updateEntity(Receta entity, RecetaUpdateDTO dto);
}
