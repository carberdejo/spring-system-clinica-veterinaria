package com.clinicAnimal.system_vet_clinica.web.controller;

import com.clinicAnimal.system_vet_clinica.aplication.service.MascotaService;
import com.clinicAnimal.system_vet_clinica.web.dto.request.MascotaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.MascotaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.MascotaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService service;

    @PostMapping
    public ResponseEntity<MascotaResponseDTO> crear(@RequestBody MascotaRequestDTO requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<MascotaResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> actualizar(@PathVariable Long id, @RequestBody MascotaUpdateDTO updateDto){
        return ResponseEntity.ok(service.actualizar(id, updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
