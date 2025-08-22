package com.clinicAnimal.system_vet_clinica.aplication.service;

import com.clinicAnimal.system_vet_clinica.web.dto.RecetaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaUpdateDTO;

import java.time.LocalDate;
import java.util.List;

public interface RecetaService {
    RecetaResponseDTO crear(RecetaRequestDTO recetaRequestDTO);
    RecetaResponseDTO obtenerPorId(Long id);
    List<RecetaResponseDTO> listar();
    List<RecetaResponseDTO> buscarPorNombre(String nombre); // similar al repo
    List<RecetaResponseDTO> buscarPorFecha(LocalDate inicio, LocalDate fin);
    RecetaResponseDTO actualizar(Long id, RecetaUpdateDTO recetaUpdateDTO);
    void eliminar(Long id);
}
