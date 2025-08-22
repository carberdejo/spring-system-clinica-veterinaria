package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import com.clinicAnimal.system_vet_clinica.domain.model.Servicios;
import com.clinicAnimal.system_vet_clinica.web.dto.request.ServicioRequestDTO;

import com.clinicAnimal.system_vet_clinica.web.dto.response.ServicioResponseDTO;

public interface ServiciosMapper {
    Servicios toEntity(ServicioRequestDTO req, Areas area);
    ServicioResponseDTO toDTO(Servicios res);
}
