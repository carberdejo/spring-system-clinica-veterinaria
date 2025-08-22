package com.clinicAnimal.system_vet_clinica.aplication.service.Impl;

import com.clinicAnimal.system_vet_clinica.aplication.service.RecetaService;
import com.clinicAnimal.system_vet_clinica.domain.model.Cita;
import com.clinicAnimal.system_vet_clinica.domain.model.Receta;
import com.clinicAnimal.system_vet_clinica.domain.repository.CitaRepository;
import com.clinicAnimal.system_vet_clinica.domain.repository.RecetaRepository;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecetaServImpl implements RecetaService {

    private final RecetaRepository recetaRepository;
    private final CitaRepository citaRepository;

    @Override
    public RecetaResponseDTO crear(RecetaRequestDTO recetaRequestDTO) {
        Cita cita = citaRepository.findById(recetaRequestDTO.getCitaId())
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + recetaRequestDTO.getCitaId()));

        LocalDateTime fecha = recetaRequestDTO.getFechaEmision() != null
                ? recetaRequestDTO.getFechaEmision()
                : LocalDateTime.now();

        Receta receta = Receta.builder()
                .fechaEmision(fecha)
                .indicaciones(recetaRequestDTO.getIndicaciones())
                .medicamentos(recetaRequestDTO.getMedicamentos())
                .cita(cita)
                .build();

        return mapToResponse(recetaRepository.save(receta));
    }

    @Override
    public RecetaResponseDTO obtenerPorId(Long id) {
        return recetaRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada con id: " + id));
    }

    @Override
    public List<RecetaResponseDTO> listar() {
        return recetaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Usa el repositorio que busca por nombre de la mascota (paciente) asociada a la cita
    @Override
    public List<RecetaResponseDTO> buscarPorNombre(String nombre) {
        return recetaRepository.findByNombreContainingIgnoreCase(nombre).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Acepta LocalDate (como en tu interfaz) y delega al repo que convierte a LocalDateTime
    @Override
    public List<RecetaResponseDTO> buscarPorFecha(LocalDate inicio, LocalDate fin) {
        return recetaRepository.findByFechaBetween(inicio, fin).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RecetaResponseDTO actualizar(Long id, RecetaUpdateDTO recetaUpdateDTO) {
        Receta receta = recetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada con id: " + id));

        if (recetaUpdateDTO.getIndicaciones() != null) {
            receta.setIndicaciones(recetaUpdateDTO.getIndicaciones());
        }
        if (recetaUpdateDTO.getMedicamentos() != null) {
            receta.setMedicamentos(recetaUpdateDTO.getMedicamentos());
        }

        return mapToResponse(recetaRepository.save(receta));
    }

    @Override
    public void eliminar(Long id) {
        if (!recetaRepository.existsById(id)) {
            throw new RuntimeException("Receta no encontrada con id: " + id);
        }
        recetaRepository.deleteById(id);
    }

    private RecetaResponseDTO mapToResponse(Receta receta) {
        Long citaId = (receta.getCita() != null) ? receta.getCita().getId() : null;
        String nombrePaciente = null;
        if (receta.getCita() != null && receta.getCita().getMascota() != null) {
            nombrePaciente = receta.getCita().getMascota().getNombre(); // "paciente" = mascota
        }

        return RecetaResponseDTO.builder()
                .id(receta.getId())
                .fechaEmision(receta.getFechaEmision())
                .indicaciones(receta.getIndicaciones())
                .medicamentos(receta.getMedicamentos())
                .citaId(citaId)
                .nombrePaciente(nombrePaciente)
                .build();
    }
}
