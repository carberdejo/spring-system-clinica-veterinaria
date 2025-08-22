package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.ClienteMapper;
import com.clinicAnimal.system_vet_clinica.aplication.mapper.MascotaMapper;
import com.clinicAnimal.system_vet_clinica.domain.model.Cliente;
import com.clinicAnimal.system_vet_clinica.web.dto.ClienteUpdateDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.request.ClienteRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.ClienteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteMapperImpl implements ClienteMapper {

    private final MascotaMapper mascotaMapper;

    @Override
    public Cliente toEntity(ClienteRequestDTO dto) {
        if (dto == null) return null;
        return Cliente.builder()
                .nombre(dto.getNombre())
                .apellidos(dto.getApellidos())
                .dni(dto.getDni())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .email(dto.getEmail())
                .build();
    }

    @Override
    public Cliente toEntityUpdate(ClienteUpdateDTO dto, Cliente cliente) {
        if (dto == null || cliente == null) return cliente;
        if (dto.getTelefono() != null) cliente.setTelefono(dto.getTelefono());
        if (dto.getDireccion() != null) cliente.setDireccion(dto.getDireccion());
        if (dto.getEmail() != null) cliente.setEmail(dto.getEmail());
        return cliente;
    }

    @Override
    public ClienteResponseDTO toResponse(Cliente cliente) {
        if (cliente == null) return null;
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellidos(cliente.getApellidos())
                .dni(cliente.getDni())
                .telefono(cliente.getTelefono())
                .direccion(cliente.getDireccion())
                .email(cliente.getEmail())
                .mascotas(cliente.getMascotas() != null
                        ? cliente.getMascotas().stream().map(mascotaMapper::toResponse).collect(Collectors.toList())
                        : null)
                .build();
    }
}
