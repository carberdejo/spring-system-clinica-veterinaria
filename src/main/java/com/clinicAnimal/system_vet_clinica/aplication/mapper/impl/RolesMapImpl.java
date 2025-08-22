package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.RolesMap;
import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import com.clinicAnimal.system_vet_clinica.web.dto.request.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.RolesResponseDTO;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class RolesMapImpl implements RolesMap {
    @Override
    public Roles toEntity(RolesRequestDTO dto) {
        return Roles.builder()
                .rolNombre(dto.getRolNombre())
                .descripcion(dto.getDescripcion())
                .build();
    }

    @Override
    public RolesResponseDTO toDto(Roles entity) {
        return RolesResponseDTO.builder()
                .rolCodigo(entity.getRolCodigo())
                .rolNombre(entity.getRolNombre())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
