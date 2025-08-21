package com.clinicAnimal.system_vet_clinica.aplication.service.Impl;

import com.clinicAnimal.system_vet_clinica.aplication.service.CitaService;
import com.clinicAnimal.system_vet_clinica.domain.model.Cita;
import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoCita;
import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;
import com.clinicAnimal.system_vet_clinica.domain.repository.CitaRepository;
import com.clinicAnimal.system_vet_clinica.domain.repository.MascotaRepository;
import com.clinicAnimal.system_vet_clinica.web.dto.CitaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.CitaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.CitaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitaServImpl implements CitaService {

    private final CitaRepository citaRepository;

    private final MascotaRepository mascotaRepository;

    @Override
    public CitaResponseDTO crear(CitaRequestDTO citaRequestDTO) {
        Mascota mascota = mascotaRepository.findById(citaRequestDTO.getMascotaId())
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        Cita cita = Cita.builder()
                .fechaHora(citaRequestDTO.getFechaHora())
                .estado(EstadoCita.PENDIENTE) // por defecto al crear
                .mascota(mascota)
                .build();

        return mapToResponse(citaRepository.save(cita));
    }

    @Override
    public CitaResponseDTO obtenerPorId(Long id) {
        return citaRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    @Override
    public List<CitaResponseDTO> listar() {
        return citaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CitaResponseDTO> listarPorMascota(Long mascotaId) {
        return citaRepository.findByMascotaId(mascotaId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CitaResponseDTO> listarPorEstado(EstadoCita estado) {
        return citaRepository.findByEstado(estado).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CitaResponseDTO actualizarEstado(Long id, CitaUpdateDTO citaUpdateDTO) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        cita.setEstado(citaUpdateDTO.getEstado());

        return mapToResponse(citaRepository.save(cita));
    }

    @Override
    public void eliminar(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepository.deleteById(id);
    }

    private CitaResponseDTO mapToResponse(Cita cita) {
        return CitaResponseDTO.builder()
                .id(cita.getId())
                .fechaHora(cita.getFechaHora())
                .estado(cita.getEstado())
                .mascotaId(cita.getMascota().getId())
                .nombreMascota(cita.getMascota().getNombre()) // asumiendo que Mascota tiene getNombre()
                .tieneReceta(cita.getReceta() != null)
                .build();
    }
}
