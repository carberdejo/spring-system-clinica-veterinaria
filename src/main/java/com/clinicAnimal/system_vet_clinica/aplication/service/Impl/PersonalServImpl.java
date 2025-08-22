package com.clinicAnimal.system_vet_clinica.aplication.service.Impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.PersonalMap;
import com.clinicAnimal.system_vet_clinica.aplication.service.PersonalService;
import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import com.clinicAnimal.system_vet_clinica.domain.model.Personal;
import com.clinicAnimal.system_vet_clinica.domain.model.Roles;
import com.clinicAnimal.system_vet_clinica.domain.repository.AreasRep;
import com.clinicAnimal.system_vet_clinica.domain.repository.PersonalRep;
import com.clinicAnimal.system_vet_clinica.domain.repository.RolesRep;
import com.clinicAnimal.system_vet_clinica.web.dto.request.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.PersonalResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalUpdateDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalServImpl implements PersonalService {
    private final PersonalMap personalMap;
    private final PersonalRep personalRep;
    private final AreasRep areasRep;
    private final RolesRep rolesRep;

    @Override
    @Transactional
    public PersonalResponseDTO crear(PersonalRequestDTO personalRequestDTO) {
        if (personalRep.existsByDni(personalRequestDTO.getDni()))
            throw new RuntimeException("Ese trabajador ya existe");
        if (!areasRep.existsByNomArea(personalRequestDTO.getNomArea())) {
            throw new RuntimeException("Esta área no existe");
        }
        if (!rolesRep.existsByRolNombre(personalRequestDTO.getRolNombre())) {
            throw new RuntimeException("Este rol no existe");
        }
        if(personalRequestDTO.getEdad() <17){
            throw new RuntimeException("Eres muy pequeño para trabajar :(");
        }
        if(personalRequestDTO.getDni().length()!=8){
            throw new RuntimeException("Tu dni debe tener 8 digitos");
        }
        if(personalRequestDTO.getTelefono().length() != 9){
            throw new RuntimeException("Todo numero de telefono debe tener 9 digitos");
        }
        Roles roles = rolesRep.findByRolNombre(personalRequestDTO.getRolNombre());
        Areas area = areasRep.findByNomArea(personalRequestDTO.getNomArea());
        Personal personal = personalMap.toEntity(personalRequestDTO,roles,area);
        personal.setFechaRegistro(LocalDate.now());
        personal.setEstadoPersonal(EstadoPersonal.DISPONIBLE);
        Personal personalGuardado = personalRep.save(personal);
        return personalMap.toDto(personalGuardado);
    }

    @Override
    public List<PersonalResponseDTO> listar() {
        return personalRep.findAllByEstadoPersonalNot(EstadoPersonal.DESPEDIDO)
                .stream()
                .map(personalMap::toDto)
                .toList();
    }

    @Override
    public PersonalResponseDTO obtenerporId(Long id) {
        Personal personal = personalRep.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el trabajador con id: " + id));
        if(personal.getEstadoPersonal().equals(EstadoPersonal.DESPEDIDO)){
            throw new RuntimeException("Este trabajador ha sido despedido");
        }
        return personalMap.toDto(personal);
    }

    @Override
    public List<PersonalResponseDTO> obtenerporRolNombre(String rolNombre) {
        List<Personal> personales = personalRep.findAllByRoles_RolNombreAndEstadoPersonalNot(rolNombre, EstadoPersonal.DESPEDIDO);
        return personales.stream()
                .map(personalMap::toDto)
                .toList()
                ;
    }

    @Override
    public PersonalResponseDTO actualizar(Long id, PersonalUpdateDTO personalUpdateDTO) {
        Personal personal = personalRep.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el trabajador con id: " + id));
        if(personalUpdateDTO.getTelefono().length() != 9){
            throw new RuntimeException("Todo numero de telefono debe tener 9 digitos");
        }
        if(personal.getEstadoPersonal().equals(personalUpdateDTO.getEstadoPersonal())){
            throw new RuntimeException("Este trabajador ya tiene ese estado");
        }
        personal.setEstadoPersonal(personalUpdateDTO.getEstadoPersonal());
        personal.setFechaEntrada(personalUpdateDTO.getFechaEntrada());
        personal.setFechaSalida(personalUpdateDTO.getFechaSalida());
        personal.setEmail(personalUpdateDTO.getEmail());
        personal.setTelefono(personalUpdateDTO.getTelefono());
        Personal personalActu = personalRep.save(personal);
        return personalMap.toDto(personalActu);
    }
}
