package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.ServiciosMapper;
import com.clinicAnimal.system_vet_clinica.domain.model.Servicios;
import com.clinicAnimal.system_vet_clinica.web.dto.ServicioRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.ServicioResponseDTO;

public class ServiciosMapperImpl implements ServiciosMapper {
    @Override
    public Servicios toEntity(ServicioRequestDTO req) {
        return Servicios.builder()
                .nombre(req.getNombre())
                .descripcion(req.getDescripcion())
                .duracion(req.getDuracion())
                .precio(req.getPrecio())
                .build();
    }

    @Override
    public ServicioResponseDTO toDTO(Servicios res) {
        return ServicioResponseDTO.builder()
                .id(res.getId())
                .nombre(res.getNombre())
                .descripcion(res.getDescripcion())
                .duracion(res.getDuracion())
                .precio(res.getPrecio())
                .build();
    }
}
