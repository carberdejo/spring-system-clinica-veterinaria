package com.clinicAnimal.system_vet_clinica.App.Service;

import com.clinicAnimal.system_vet_clinica.Domain.Models.Roles;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesResponseDTO;

import java.util.List;

public interface RolesService {
   RolesResponseDTO crear(RolesRequestDTO rolesRequestDTO);
    List<RolesResponseDTO> listar();
    RolesResponseDTO obtenerporId(Long id);
    RolesResponseDTO actualizar(RolesRequestDTO rolesRequestDTO,Long id);
}
