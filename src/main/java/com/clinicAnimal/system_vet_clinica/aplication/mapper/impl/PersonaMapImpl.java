package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.PersonalMap;
import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import com.clinicAnimal.system_vet_clinica.Web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.PersonalResponseDTO;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class PersonaMapImpl implements PersonalMap {
    @Override
    public Personal toEntity(PersonalRequestDTO dto, Roles roles) {
        return Personal.builder()
                .nombrePersonal(dto.getNombrePersonal())
                .edad(dto.getEdad())
                .dni(dto.getDni())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .apellidoPersonal(dto.getApellidoPersonal())
                .roles(roles)
                .build();
    }

    @Override
    public PersonalResponseDTO toDto(Personal entity) {
        return PersonalResponseDTO.builder()
                .per_id(entity.getPer_id())
                .nombrePersonal(entity.getNombrePersonal())
                .apellidoPersonal(entity.getApellidoPersonal())
                .dni(entity.getDni())
                .email(entity.getEmail())
                .telefono(entity.getTelefono())
                .estadoPersonal(entity.getEstadoPersonal())
                .build();
    }
}
