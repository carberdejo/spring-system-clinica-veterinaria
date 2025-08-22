package com.clinicAnimal.system_vet_clinica.aplication.service;

import com.clinicAnimal.system_vet_clinica.web.dto.request.ClienteRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.ClienteResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO crear(ClienteRequestDTO clienteRequestDTO);
    ClienteResponseDTO obtenerPorId(Long id);
    List<ClienteResponseDTO> listar();
    ClienteResponseDTO actualizar(Long id, ClienteUpdateDTO clienteUpdateDTO);
    void eliminar(Long id);
}
