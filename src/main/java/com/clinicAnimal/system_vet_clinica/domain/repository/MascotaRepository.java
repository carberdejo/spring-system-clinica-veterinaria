package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Mascota;

import java.util.List;

public interface MascotaRepository {
    List<Mascota> findByClienteId(Long clienteId);
    List<Mascota> findByRaza(String raza);
}
