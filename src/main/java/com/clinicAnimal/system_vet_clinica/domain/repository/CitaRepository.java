package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Cita;
import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    // Buscar todas las citas por mascota
    List<Cita> findByMascotaId(Long mascotaId);

    // Buscar citas por estado (PROGRAMADA, INACTIVA, COMPLETADA, etc.)
    List<Cita> findByEstado(EstadoCita estado);
}