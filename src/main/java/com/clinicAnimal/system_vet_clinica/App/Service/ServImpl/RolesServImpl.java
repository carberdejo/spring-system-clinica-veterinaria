package com.clinicAnimal.system_vet_clinica.App.Service.ServImpl;

import com.clinicAnimal.system_vet_clinica.App.Mapping.RolesMap;
import com.clinicAnimal.system_vet_clinica.App.Service.RolesService;
import com.clinicAnimal.system_vet_clinica.Domain.Models.Roles;
import com.clinicAnimal.system_vet_clinica.Domain.Models.repository.RolesRep;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesResponseDTO;
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

        return null;
    }

    @Override
    public RolesResponseDTO actualizar(RolesRequestDTO rolesRequestDTO, Long id) {
        return null;
    }
}
