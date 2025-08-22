package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Cita;
import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;
import com.clinicAnimal.system_vet_clinica.web.dto.request.CitaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.CitaResponseDTO;

public interface CitaMap {
    Cita toEntity(CitaRequestDTO dto, Mascota mascota);
    CitaResponseDTO toDto(Cita entity);
}
