package com.clinicAnimal.system_vet_clinica.web.controller;

import com.clinicAnimal.system_vet_clinica.aplication.service.CitaService;
import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoCita;
import com.clinicAnimal.system_vet_clinica.web.dto.request.CitaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.response.CitaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.CitaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaResponseDTO>> listar() {
        return ResponseEntity.ok(citaService.listar());
    }

    @PostMapping
    public ResponseEntity<CitaResponseDTO> crear(@RequestBody CitaRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(citaService.crear(requestDTO));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<CitaResponseDTO> actualizarEstado(@PathVariable Long id,
                                                            @RequestBody CitaUpdateDTO requestDTO) {
        return ResponseEntity.ok(citaService.actualizarEstado(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.obtenerPorId(id));
    }

    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<List<CitaResponseDTO>> listarPorMascota(@PathVariable Long mascotaId) {
        return ResponseEntity.ok(citaService.listarPorMascota(mascotaId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CitaResponseDTO>> listarPorEstado(@PathVariable EstadoCita estado) {
        return ResponseEntity.ok(citaService.listarPorEstado(estado));
    }
}
