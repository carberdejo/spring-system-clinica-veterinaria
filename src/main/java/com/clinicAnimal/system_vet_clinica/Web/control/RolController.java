package com.clinicAnimal.system_vet_clinica.Web.control;

import com.clinicAnimal.system_vet_clinica.App.Service.RolesService;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.Web.dto.RolesResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
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


}
