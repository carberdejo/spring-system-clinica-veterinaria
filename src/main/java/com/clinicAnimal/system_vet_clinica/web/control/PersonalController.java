package com.clinicAnimal.system_vet_clinica.web.control;

import com.clinicAnimal.system_vet_clinica.aplication.service.PersonalService;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.PersonalUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Personal")
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalService service;
    @PostMapping
    public ResponseEntity<PersonalResponseDTO> crear(@RequestBody PersonalRequestDTO requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(requestDto));
    }
    @GetMapping
    public ResponseEntity<List<PersonalResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalResponseDTO> BuscarporId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.obtenerporId(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<PersonalResponseDTO> actualizarRoles(
            @PathVariable("id") Long id,
            @RequestBody PersonalUpdateDTO personalUpdateDTO) {

        PersonalResponseDTO dtoActualizado = service.actualizar(id, personalUpdateDTO);
        return ResponseEntity.ok(dtoActualizado);
    }
    @GetMapping("/RolABuscar/{rolNombre}")
    public ResponseEntity<List<PersonalResponseDTO>> listarRoles(@PathVariable String rolNombre){
        return ResponseEntity.ok(service.obtenerporRolNombre(rolNombre));
    }

}
