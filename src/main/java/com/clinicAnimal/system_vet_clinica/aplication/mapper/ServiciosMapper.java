package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Servicios;
import com.clinicAnimal.system_vet_clinica.web.dto.ServicioRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.ServicioResponseDTO;

public interface ServiciosMapper {
    Servicios toEntity(ServicioRequestDTO req);
    ServicioResponseDTO toDTO(Servicios res);
}
