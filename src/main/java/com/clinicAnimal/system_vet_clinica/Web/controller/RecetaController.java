package com.clinicAnimal.system_vet_clinica.web.controller;

import com.clinicAnimal.system_vet_clinica.aplication.service.RecetaService;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/recetas")
@RequiredArgsConstructor
public class RecetaController {

    private final RecetaService recetaService;


    @GetMapping
    public ResponseEntity<List<RecetaResponseDTO>> listar() {
        return ResponseEntity.ok(recetaService.listar());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RecetaResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(recetaService.obtenerPorId(id));
    }


    @PostMapping
    public ResponseEntity<RecetaResponseDTO> crear(@RequestBody RecetaRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(recetaService.crear(requestDTO));
    }


    @PutMapping("/{id}")
    public ResponseEntity<RecetaResponseDTO> actualizar(@PathVariable Long id,
                                                        @RequestBody RecetaUpdateDTO updateDTO) {
        return ResponseEntity.ok(recetaService.actualizar(id, updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        recetaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<RecetaResponseDTO>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(recetaService.buscarPorNombre(nombre));
    }


    @GetMapping("/fecha")
    public ResponseEntity<List<RecetaResponseDTO>> buscarPorFecha(
            @RequestParam String inicio,
            @RequestParam String fin) {
        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);
        return ResponseEntity.ok(recetaService.buscarPorFecha(fechaInicio, fechaFin));
    }
}

