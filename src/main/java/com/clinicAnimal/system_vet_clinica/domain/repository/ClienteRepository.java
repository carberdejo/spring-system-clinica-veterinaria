package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    List<Cliente> findByDni(String dni);
}
