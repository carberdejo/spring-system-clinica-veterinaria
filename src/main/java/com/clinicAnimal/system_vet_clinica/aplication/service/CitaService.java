package com.clinicAnimal.system_vet_clinica.aplication.service;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoCita;
import com.clinicAnimal.system_vet_clinica.web.dto.request.CitaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.CitaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.CitaUpdateDTO;

import java.util.List;

public interface CitaService {
    CitaResponseDTO crear(CitaRequestDTO citaRequestDTO);
    CitaResponseDTO obtenerPorId(Long id);
    List<CitaResponseDTO> listar();
    List<CitaResponseDTO> listarPorMascota(Long mascotaId);
    List<CitaResponseDTO> listarPorEstado(EstadoCita estado);
    CitaResponseDTO actualizarEstado(Long id, CitaUpdateDTO citaUpdateDTO);
    void eliminar(Long id);
}
