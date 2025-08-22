package com.clinicAnimal.system_vet_clinica.web.controller;

import com.clinicAnimal.system_vet_clinica.aplication.service.RolesService;
import com.clinicAnimal.system_vet_clinica.web.dto.request.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.RolesResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Rol")
@RequiredArgsConstructor

public class RolController {
    private final RolesService service;
    @PostMapping
    public ResponseEntity<RolesResponseDTO> crear(@RequestBody RolesRequestDTO requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(requestDto));
    }
    @GetMapping
    public ResponseEntity<List<RolesResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolesResponseDTO> BuscarporId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.obtenerporId(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<RolesResponseDTO> actualizarRoles(@PathVariable("id") Long id,@RequestBody RolesRequestDTO rolesRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.actualizar(rolesRequestDTO , id));
    }



}
