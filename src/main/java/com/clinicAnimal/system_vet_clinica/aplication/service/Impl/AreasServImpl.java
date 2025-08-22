package com.clinicAnimal.system_vet_clinica.aplication.service.Impl;


import com.clinicAnimal.system_vet_clinica.aplication.mapper.AreasMap;
import com.clinicAnimal.system_vet_clinica.aplication.service.AreaService;
import com.clinicAnimal.system_vet_clinica.domain.model.Areas;
import com.clinicAnimal.system_vet_clinica.domain.repository.AreasRep;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.AreasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreasServImpl implements AreaService{
    private final AreasMap areasMap;
    private final AreasRep areasRep;

    @Override
    public AreasResponseDTO crear(AreasRequestDTO areasRequestDTO) {
        if(areasRep.existsByNomArea(areasRequestDTO.getNomArea()))
            throw new RuntimeException("Esa Area ya existe");
        Areas areas = areasMap.toEntity(areasRequestDTO);
        return areasMap.toDto(areasRep.save(areas));
    }

    @Override
    public List<AreasResponseDTO> listar() {
        return areasRep.findAll()
                .stream()
                .map(areasMap::toDto)
                .toList();
    }

    @Override
    public AreasResponseDTO obtenerporId(Long id) {
        Areas areaBuscada = areasRep.findById(id).orElseThrow(()
        -> new RuntimeException("Esa area no existe"));

        return areasMap.toDto(areaBuscada);
    }

    @Override
    public AreasResponseDTO actualizar(AreasRequestDTO areasRequestDTO, Long id) {
        Areas areaBuscada = areasRep.findById(id).orElseThrow(()
                -> new RuntimeException("Esa area no existe"));
        areaBuscada.setNomArea(areasRequestDTO.getNomArea());
        areaBuscada.setDescripcion(areasRequestDTO.getDescripcion());
        Areas areaActualizada= areasRep.save(areaBuscada);
        return areasMap.toDto(areaActualizada);
    }


}
