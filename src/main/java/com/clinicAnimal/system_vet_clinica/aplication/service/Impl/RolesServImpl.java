package com.clinicAnimal.system_vet_clinica.aplication.service.Impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.RolesMap;
import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import com.clinicAnimal.system_vet_clinica.domain.repository.RolesRep;
import com.clinicAnimal.system_vet_clinica.web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RolesResponseDTO;
import com.clinicAnimal.system_vet_clinica.aplication.service.RolesService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesServImpl implements RolesService {
    private final RolesMap rolesMap;
    private final RolesRep rolesRep;

    @Override
    @Transactional
    public RolesResponseDTO crear(RolesRequestDTO rolesRequestDTO) {
        if(rolesRep.existsByRolNombre(rolesRequestDTO.getRolNombre())){
            throw new RuntimeException("Este rol ya existe");
        }
        Roles roles = rolesMap.toEntity(rolesRequestDTO);
        return rolesMap.toDto(rolesRep.save(roles));
    }

    @Override
    public List<RolesResponseDTO> listar() {
        return rolesRep.findAll()
                .stream()
                .map(rolesMap::toDto)
                .toList();
    }

    @Override
    public RolesResponseDTO obtenerporId(Long id) {
    Roles rolbuscado = rolesRep.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el Rol con id: " + id));

        return rolesMap.toDto(rolbuscado);
    }

    @Override
    public RolesResponseDTO actualizar(RolesRequestDTO rolesRequestDTO, Long id)
    {
        Roles rolbuscado = rolesRep.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el Rol con id: " + id));
        rolbuscado.setRolNombre(rolesRequestDTO.getRolNombre());
        rolbuscado.setDescripcion(rolesRequestDTO.getDescripcion());
        Roles rolActualizado = rolesRep.save(rolbuscado);

        return rolesMap.toDto(rolActualizado);
    }
}
