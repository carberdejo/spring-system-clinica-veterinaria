package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.PersonalMap;
import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import com.clinicAnimal.system_vet_clinica.domain.model.Roles;

import com.clinicAnimal.system_vet_clinica.web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalResponseDTO;

import com.clinicAnimal.system_vet_clinica.web.dto.*;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class PersonaMapImpl implements PersonalMap {
    @Override
    public Personal toEntity(PersonalRequestDTO dto, Roles roles, Areas areas) {
        return Personal.builder()
                .nombrePersonal(dto.getNombrePersonal())
                .edad(dto.getEdad())
                .dni(dto.getDni())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .apellidoPersonal(dto.getApellidoPersonal())
                .fechaEntrada(dto.getFechaEntrada())
                .fechaSalida(dto.getFechaSalida())
                .estadoPersonal(EstadoPersonal.DISPONIBLE)
                .roles(roles)
                .areas(areas)
                .build();
    }

    @Override
    public PersonalResponseDTO toDto(Personal entity) {
        return PersonalResponseDTO.builder()
                .perId(entity.getPerId())
                .nombrePersonal(entity.getNombrePersonal())
                .apellidoPersonal(entity.getApellidoPersonal())
                .edad(entity.getEdad())
                .dni(entity.getDni())
                .email(entity.getEmail())
                .telefono(entity.getTelefono())
                .estadoPersonal(entity.getEstadoPersonal())
                .nomArea(entity.getAreas().getNomArea())
                .rolNombre(entity.getRoles().getRolNombre())
                .fechaRegistro(entity.getFechaRegistro())
                .fechaEntrada(entity.getFechaEntrada())
                .fechaSalida(entity.getFechaSalida())
                .build();
    }
}
