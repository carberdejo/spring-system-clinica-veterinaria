package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.ServiciosMapper;
import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import com.clinicAnimal.system_vet_clinica.domain.model.Servicios;
import com.clinicAnimal.system_vet_clinica.web.dto.request.ServicioRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.ServicioResponseDTO;


public class ServiciosMapperImpl implements ServiciosMapper {
    @Override
    public Servicios toEntity(ServicioRequestDTO req, Areas area) {
        return Servicios.builder()
                .nombre(req.getNombre())
                .descripcion(req.getDescripcion())
                .duracion(req.getDuracion())
                .precio(req.getPrecio())
                .area(area)
                .build();
    }


    @Override
    public ServicioResponseDTO toDTO(Servicios res) {
        return ServicioResponseDTO.builder()
                .id(res.getId())
                .nombre(res.getNombre())
                .descripcion(res.getDescripcion())
                .precio(res.getPrecio())
                .duracion(res.getDuracion())
                .idArea(res.getArea().getCodigoArea())
                .nomArea(res.getArea().getNomArea())
                .build();
    }
}
