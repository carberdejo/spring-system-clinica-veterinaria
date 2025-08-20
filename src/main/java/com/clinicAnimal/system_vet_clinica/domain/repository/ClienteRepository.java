package com.clinicAnimal.system_vet_clinica.domain.repository;

import com.clinicAnimal.system_vet_clinica.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //en caso si se desea  buscar por DNI
    Optional<Cliente> findByDni(String dni);
    //en caso si se desea  buscar por nombre
    List<Cliente> findByNombre(String nombre);
}
