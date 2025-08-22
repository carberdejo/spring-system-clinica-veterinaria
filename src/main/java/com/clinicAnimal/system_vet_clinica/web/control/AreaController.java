package com.clinicAnimal.system_vet_clinica.web.control;


import com.clinicAnimal.system_vet_clinica.aplication.service.AreaService;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RolesRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RolesResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Area")
@RequiredArgsConstructor
public class AreaController {
    private final AreaService service;

    @PostMapping
    public ResponseEntity<AreasResponseDTO> crear(@RequestBody AreasRequestDTO requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(requestDto));
    }
    @GetMapping
    public ResponseEntity<List<AreasResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AreasResponseDTO> BuscarporId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.obtenerporId(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<AreasResponseDTO> actualizarAreas(@PathVariable("id") Long id,@RequestBody AreasRequestDTO areaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.actualizar(areaRequestDTO , id));
    }

}
