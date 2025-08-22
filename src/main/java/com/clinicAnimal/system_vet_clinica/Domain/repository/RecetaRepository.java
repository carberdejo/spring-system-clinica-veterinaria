package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
    // Esto es de la corrección anterior, pero podría ser diferente si lo cambiaste.
    List<Receta> findByIndicacionesContainingIgnoreCase(String indicaciones);

    // CORRECCIÓN: Ahora busca por 'fechaEmision'
    List<Receta> findByFechaEmisionBetween(LocalDate inicio, LocalDate fin);
}