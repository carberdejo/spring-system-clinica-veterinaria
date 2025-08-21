package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Receta;

import java.time.LocalDate;
import java.util.List;

public interface RecetaRepository {
    List<Receta> findByNombreContainingIgnoreCase(String nombre);


    List<Receta> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
