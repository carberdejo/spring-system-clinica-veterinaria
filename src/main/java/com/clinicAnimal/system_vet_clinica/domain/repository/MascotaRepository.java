package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByNombreContainingIgnoreCase(String nombre);
    List<Mascota> findByRazaContainingIgnoreCase(String raza);
    List<Mascota> findByClienteId(Long clienteId);
}
