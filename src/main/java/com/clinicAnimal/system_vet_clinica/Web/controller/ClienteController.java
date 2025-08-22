package com.clinicAnimal.system_vet_clinica.web.controller;

import com.clinicAnimal.system_vet_clinica.aplication.service.ClienteService;
import com.clinicAnimal.system_vet_clinica.web.dto.request.ClienteRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.ClienteResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.ClienteUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crear(@RequestBody ClienteRequestDTO requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizar(@PathVariable Long id, @RequestBody ClienteUpdateDTO updateDto){
        return ResponseEntity.ok(service.actualizar(id, updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
