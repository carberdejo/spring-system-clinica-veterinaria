package com.clinicAnimal.system_vet_clinica.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_alquiler")
    private Long id ;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellidos;
    @Column(name="dni")
    private String dni ;
    @Column(name="telefono")
    private String telefono;
    @Column(name="direccion")
    private String direccion;
    @Column(name="email")
    private String email;
    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas;

    
}
