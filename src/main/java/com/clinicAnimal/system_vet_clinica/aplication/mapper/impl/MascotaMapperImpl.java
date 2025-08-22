package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.MascotaMapper;
import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;
import com.clinicAnimal.system_vet_clinica.web.dto.MascotaUpdateDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.request.MascotaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.MascotaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapperImpl implements MascotaMapper {

    @Override
    public Mascota toEntity(MascotaRequestDTO dto) {
        if (dto == null) return null;
        return Mascota.builder()
                .nombre(dto.getNombre())
                .raza(dto.getRaza())
                .edad(dto.getEdad())
                .sexo(dto.getSexo())
                .build();
    }

    @Override
    public Mascota toEntityUpdate(MascotaUpdateDTO dto, Mascota mascota) {
        if (dto == null || mascota == null) return mascota;
        if (dto.getNombre() != null) mascota.setNombre(dto.getNombre());
        if (dto.getRaza() != null) mascota.setRaza(dto.getRaza());
        if (dto.getEdad() > 0) mascota.setEdad(dto.getEdad());
        if (dto.getSexo() != null) mascota.setSexo(dto.getSexo());
        return mascota;
    }

    @Override
    public MascotaResponseDTO toResponse(Mascota mascota) {
        if (mascota == null) return null;
        return MascotaResponseDTO.builder()
                .id(mascota.getId())
                .nombre(mascota.getNombre())
                .raza(mascota.getRaza())
                .edad(mascota.getEdad())
                .sexo(mascota.getSexo())
                .clienteId(mascota.getCliente() != null ? mascota.getCliente().getId() : null)
                .build();
    }
}
