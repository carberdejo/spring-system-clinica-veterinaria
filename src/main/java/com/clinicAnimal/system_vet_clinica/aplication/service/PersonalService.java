package com.clinicAnimal.system_vet_clinica.aplication.service;

import com.clinicAnimal.system_vet_clinica.web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalUpdateDTO;

import java.util.List;

public interface PersonalService {
    PersonalResponseDTO crear(PersonalRequestDTO personalRequestDTO);
    List<PersonalResponseDTO> listar();
    PersonalResponseDTO obtenerporId(Long id);
    List<PersonalResponseDTO> obtenerporRolNombre(String rolNombre);
    PersonalResponseDTO actualizar(Long id, PersonalUpdateDTO personalUpdateDTO);
}
