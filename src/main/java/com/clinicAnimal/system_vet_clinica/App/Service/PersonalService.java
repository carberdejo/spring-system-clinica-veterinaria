package com.clinicAnimal.system_vet_clinica.App.Service;

import com.clinicAnimal.system_vet_clinica.Domain.Models.Roles;
import com.clinicAnimal.system_vet_clinica.Web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.PersonalResponseDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesResponseDTO;

import java.util.List;

public interface PersonalService {
    PersonalResponseDTO crear(PersonalRequestDTO personalRequestDTO);
    List<Roles> listar();
    RolesResponseDTO obtenerporId(Long id);
}
