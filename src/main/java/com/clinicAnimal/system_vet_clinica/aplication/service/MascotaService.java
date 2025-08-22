package com.clinicAnimal.system_vet_clinica.aplication.service;

import com.clinicAnimal.system_vet_clinica.web.dto.request.MascotaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.MascotaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.MascotaUpdateDTO;

import java.util.List;

public interface MascotaService {
    MascotaResponseDTO crear(MascotaRequestDTO mascotaRequestDTO);
    MascotaResponseDTO obtenerPorId(Long id);
    List<MascotaResponseDTO> listar();
    MascotaResponseDTO actualizar(Long id, MascotaUpdateDTO mascotaUpdateDTO);
    void eliminar(Long id);
}
