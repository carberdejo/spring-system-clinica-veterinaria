package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.AreasMap;
import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasResponseDTO;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class AreasMapImpl implements AreasMap {
    @Override
    public Areas toEntity(AreasRequestDTO dto) {
        return Areas.builder()
                .nomArea(dto.getNomArea())
                .descripcion(dto.getDescripcion())
                .build();
    }

    @Override
    public AreasResponseDTO toDto(Areas entity) {
        return AreasResponseDTO.builder()
                .codigoArea(entity.getCodigoArea())
                .nomArea(entity.getNomArea())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
