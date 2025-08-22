package com.clinicAnimal.system_vet_clinica.aplication.service.Impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.MascotaMapper;
import com.clinicAnimal.system_vet_clinica.aplication.service.MascotaService;
import com.clinicAnimal.system_vet_clinica.domain.model.Cliente;
import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;
import com.clinicAnimal.system_vet_clinica.domain.repository.ClienteRepository;
import com.clinicAnimal.system_vet_clinica.domain.repository.MascotaRepository;
import com.clinicAnimal.system_vet_clinica.web.dto.request.MascotaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.MascotaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.MascotaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MascotaServImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final ClienteRepository clienteRepository;
    private final MascotaMapper mascotaMapper;

    @Override
    public MascotaResponseDTO crear(MascotaRequestDTO mascotaRequestDTO) {
        Mascota mascota = mascotaMapper.toEntity(mascotaRequestDTO);
        Cliente cliente = clienteRepository.findById(mascotaRequestDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + mascotaRequestDTO.getClienteId()));
        mascota.setCliente(cliente);
        return mascotaMapper.toResponse(mascotaRepository.save(mascota));
    }

    @Override
    public MascotaResponseDTO obtenerPorId(Long id) {
        return mascotaRepository.findById(id)
                .map(mascotaMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
    }

    @Override
    public List<MascotaResponseDTO> listar() {
        return mascotaRepository.findAll().stream()
                .map(mascotaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MascotaResponseDTO actualizar(Long id, MascotaUpdateDTO mascotaUpdateDTO) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));

        mascotaMapper.toEntityUpdate(mascotaUpdateDTO, mascota);
        return mascotaMapper.toResponse(mascotaRepository.save(mascota));
    }

    @Override
    public void eliminar(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RuntimeException("Mascota no encontrada con id: " + id);
        }
        mascotaRepository.deleteById(id);
    }
}
