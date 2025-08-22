package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;
import com.clinicAnimal.system_vet_clinica.web.dto.request.MascotaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.MascotaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.MascotaUpdateDTO;

public interface MascotaMapper {
    Mascota toEntity(MascotaRequestDTO dto);
    Mascota toEntityUpdate(MascotaUpdateDTO dto, Mascota mascota);
    MascotaResponseDTO toResponse(Mascota mascota);
}
