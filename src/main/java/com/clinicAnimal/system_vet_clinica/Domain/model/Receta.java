package com.clinicAnimal.system_vet_clinica.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "receta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private Long id;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Column(name = "indicaciones")
    private String indicaciones;

    @Column(name = "medicamentos")
    private String medicamentos;

    @OneToOne
    @JoinColumn(name = "cita_id", unique = true)
    private Cita cita;
}
