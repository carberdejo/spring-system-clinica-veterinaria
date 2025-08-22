package com.clinicAnimal.system_vet_clinica.aplication.service;

import com.clinicAnimal.system_vet_clinica.web.dto.request.AreasRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.AreasResponseDTO;

import java.util.List;

public interface AreaService {
    AreasResponseDTO crear(AreasRequestDTO areasRequestDTO);
    List<AreasResponseDTO> listar();
    AreasResponseDTO obtenerporId(Long id);
    AreasResponseDTO actualizar(AreasRequestDTO areasRequestDTO,Long id);
}
