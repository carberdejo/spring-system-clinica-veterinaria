package com.clinicAnimal.system_vet_clinica.aplication.mapper.impl;

import com.clinicAnimal.system_vet_clinica.aplication.mapper.RecetaMap;
import com.clinicAnimal.system_vet_clinica.domain.model.Cita;
import com.clinicAnimal.system_vet_clinica.domain.model.Receta;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaRequestDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaResponseDTO;
import com.clinicAnimal.system_vet_clinica.web.dto.RecetaUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class RecetaMapImpl implements RecetaMap {

    @Override
    public Receta toEntity(RecetaRequestDTO req, Cita cita) {
        return Receta.builder()
                .fechaEmision(req.getFechaEmision())
                .indicaciones(req.getIndicaciones())
                .medicamentos(req.getMedicamentos())
                .cita(cita)
                .build();
    }

    @Override
    public RecetaResponseDTO toDto(Receta res) {
        return RecetaResponseDTO.builder()
                .id(res.getId())
                .fechaEmision(res.getFechaEmision())
                .indicaciones(res.getIndicaciones())
                .medicamentos(res.getMedicamentos())
                .citaId(res.getCita().getId())
                .nombrePaciente(res.getCita().getMascota().getNombre())
                .build();
    }

    @Override
    public void updateEntity(Receta entity, RecetaUpdateDTO dto) {
        entity.setIndicaciones(dto.getIndicaciones());
        entity.setMedicamentos(dto.getMedicamentos());
    }
}
