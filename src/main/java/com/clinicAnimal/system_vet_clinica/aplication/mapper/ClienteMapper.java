package com.clinicAnimal.system_vet_clinica.aplication.mapper;

import com.clinicAnimal.system_vet_clinica.domain.model.Cliente;
import com.clinicAnimal.system_vet_clinica.web.dto.request.ClienteRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.ClienteResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.ClienteUpdateDTO;

public interface ClienteMapper {
    Cliente toEntity(ClienteRequestDTO dto);
    Cliente toEntityUpdate(ClienteUpdateDTO dto, Cliente cliente);
    ClienteResponseDTO toResponse(Cliente cliente);
}
