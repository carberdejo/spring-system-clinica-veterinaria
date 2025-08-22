package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.CitaMap;
import com.clinicAnimal.system_vet_clinica.domain.model.Cita;
import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoCita;
import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;
import com.clinicAnimal.system_vet_clinica.web.dto.request.CitaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.CitaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CitaMapImpl implements CitaMap {

    @Override
    public Cita toEntity(CitaRequestDTO dto, Mascota mascota) {
        return Cita.builder()
                .fechaHora(dto.getFechaHora())
                .estado(EstadoCita.PENDIENTE)
                .mascota(mascota)
                .build();
    }

    @Override
    public CitaResponseDTO toDto(Cita entity) {
        return CitaResponseDTO.builder()
                .id(entity.getId())
                .fechaHora(entity.getFechaHora())
                .estado(entity.getEstado())
                .mascotaId(entity.getMascota().getId())
                .nombreMascota(entity.getMascota().getNombre())
                .tieneReceta(entity.getReceta() != null)
                .build();
    }
}
