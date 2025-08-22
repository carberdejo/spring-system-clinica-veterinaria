package com.clinicAnimal.system_vet_clinica.aplication.service.Impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.ClienteMapper;
import com.clinicAnimal.system_vet_clinica.aplication.service.ClienteService;
import com.clinicAnimal.system_vet_clinica.domain.model.Cliente;
import com.clinicAnimal.system_vet_clinica.domain.repository.ClienteRepository;
import com.clinicAnimal.system_vet_clinica.web.dto.request.ClienteRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.ClienteResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.ClienteUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponseDTO crear(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteRequestDTO);
        return clienteMapper.toResponse(clienteRepository.save(cliente));
    }

    @Override
    public ClienteResponseDTO obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }

    @Override
    public List<ClienteResponseDTO> listar() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO actualizar(Long id, ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));

        clienteMapper.toEntityUpdate(clienteUpdateDTO, cliente);
        return clienteMapper.toResponse(clienteRepository.save(cliente));
    }

    @Override
    public void eliminar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado con id: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
